/*
 * The MIT License
 *
 * Copyright 2021 Angelo Geulin.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

import java.util.HashMap;

/**
 *
 * @author Angelo Geulin
 */
public class Accounts {
    private static HashMap<String, Account> accounts;
    
    private static String logged_in_user = "";
    
    private static boolean initialized = false;
    
    public static void init() {
        accounts = new HashMap<>();
        initialized = true;
    }
    
    public static boolean isInitialized() {
        return initialized;
    }
    
    public static void addAccount(Account account) {
        accounts.put(account.getPhoneNumber(), account);
    }
    
    public static Account getAccount(String phone_number) {
        return accounts.get(phone_number);
    }
    
    public static boolean phoneExists(String phone_number) {
        boolean result = false;
        if (accounts.keySet().contains(phone_number))
            result = true;
        
        return result;
    }
    
    public static void setLoggedInUser(String phone_number) {
        logged_in_user = phone_number;
    }
    
    public static String getLoggedInUser() {
        return logged_in_user;
    }
    
    public static void clearLoggedInUser() {
        logged_in_user = "";
    }
}
