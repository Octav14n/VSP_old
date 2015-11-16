package restopoly.accesslayer.banks;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import restopoly.accesslayer.exceptions.BankAccountAlreadyExistsException;
import restopoly.accesslayer.exceptions.BankAccountNotFoundException;
import restopoly.accesslayer.exceptions.BankInsufficientFundsException;
import restopoly.accesslayer.exceptions.BankNotFoundException;
import restopoly.dataaccesslayer.entities.Bank;
import restopoly.dataaccesslayer.entities.BankAccount;
import restopoly.dataaccesslayer.entities.BankList;
import restopoly.dataaccesslayer.entities.Event;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by octavian on 16.11.15.
 */
@RestController @RequestMapping("/banks") public class BanksController {
    private BankList bankList = new BankList();

    @RequestMapping(value = "/{gameid}/players", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createBankAccount(@PathVariable int gameid, @RequestBody BankAccount bankAccount) {
        Bank bank = bankList.getBank(gameid);
        if (bank == null)
            bank = bankList.createBank(gameid);
        if (bank.isBankAccountExists(bankAccount))
            throw new BankAccountAlreadyExistsException();
        bank.addBankAccount(bankAccount);
    }

    @RequestMapping(value = "/{gameid}/players", method = RequestMethod.GET)
    public List<BankAccount> getBankAccounts(@PathVariable int gameid) {
        Bank bank = bankList.getBank(gameid);
        if (bank == null)
            throw new BankNotFoundException();
        return bank.getBankAccounts();
    }

    @RequestMapping(value = "/{gameid}/players/{playerid}", method = RequestMethod.GET)
    public int getBankAccountSaldo(@PathVariable int gameid, String playerid) {
        Bank bank = bankList.getBank(gameid);
        if (bank == null)
            throw new BankNotFoundException();
        BankAccount bankAccount = bank.getBankAccount(playerid);
        if (bankAccount == null)
            throw new BankAccountNotFoundException();
        return bankAccount.getSaldo();
    }

    @RequestMapping(value = "/{gameid}/transfer/to/{to}/{amount}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public List<Event> createBankTransferTo(@PathVariable int gameid, @PathVariable String to,
        @PathVariable int amount, @RequestBody String reason) {
        Bank bank = bankList.getBank(gameid);
        if (bank == null)
            throw new BankNotFoundException();
        BankAccount bankAccountTo = bank.getBankAccount(to);
        if (bankAccountTo == null)
            throw new BankAccountNotFoundException();
        bankAccountTo.addSaldo(amount);
        return Collections.emptyList();
    }

    @RequestMapping(value = "/{gameid}/transfer/from/{from}/{amount}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public List<Event> createBankTransferFrom(@PathVariable int gameid, @PathVariable String from,
        @PathVariable int amount, @RequestBody String reason) {
        Bank bank = bankList.getBank(gameid);
        if (bank == null)
            throw new BankNotFoundException();
        BankAccount bankAccountFrom = bank.getBankAccount(from);
        if (bankAccountFrom == null)
            throw new BankAccountNotFoundException();
        if (bankAccountFrom.getSaldo() < amount)
            throw new BankInsufficientFundsException();
        bankAccountFrom.addSaldo(-amount);
        return Collections.emptyList();
    }

    @RequestMapping(value = "/{gameid}/transfer/from/{from}/to/{to}/{amount}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public List<Event> createBankTransfer(@PathVariable int gameid, @PathVariable String from,
        @PathVariable String to, @PathVariable int amount, @RequestBody String reason) {
        List<Event> events;
        events = createBankTransferFrom(gameid, from, amount, reason);
        events.addAll(createBankTransferTo(gameid, to, amount, reason));
        return events;
    }
}
