package com.bank.money.transfer.dao;

import java.math.BigDecimal;
import java.util.List;

import com.bank.money.transfer.exception.CustomException;
import com.bank.money.transfer.model.Account;
import com.bank.money.transfer.model.UserTransaction;


public interface AccountDAO {

    List<Account> getAllAccounts() throws CustomException;
    Account getAccountById(long accountId) throws CustomException;
    long createAccount(Account account) throws CustomException;
    int deleteAccountById(long accountId) throws CustomException;

    /**
     *
     * @param accountId user accountId
     * @param deltaAmount amount to be debit(less than 0)/credit(greater than 0).
     * @return no. of rows updated
     */
    int updateAccountBalance(long accountId, BigDecimal deltaAmount) throws CustomException;
    int transferAccountBalance(UserTransaction userTransaction) throws CustomException;
}
