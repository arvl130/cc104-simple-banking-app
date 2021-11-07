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

import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;

/**
 *
 * @author Angelo Geulin
 */
public class Account {

    private String phone_number;
    private String name;
    private double balance;
    private String pin;
    private Queue<HistoryEntry> history;

    public Account(String phone_number, String name, double balance, String pin) {
        this.phone_number = phone_number;
        this.name = name;
        this.balance = balance;
        this.pin = pin;
        this.history = new LinkedList<>();
        
        this.recordHistory("Account created.");
    }

    public String getPhoneNumber() {
        return phone_number;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public String getPIN() {
        return pin;
    }
    
    public final void recordHistory(String entry_description) {
        HistoryEntry entry = new HistoryEntry(entry_description);
        history.add(entry);
    }
    
    public String[][] getHistory() {
        // Instantiate reverse copy of history.
        LinkedList<HistoryEntry> history_reverse = new LinkedList<>();
        history_reverse.addAll(history);
        Collections.reverse(history_reverse);
        
        // Convert stack of objects to array using Stream class.
        // ref: https://stackoverflow.com/questions/35131702/how-to-convert-java-list-of-objects-to-2d-array
        //      https://stackoverflow.com/questions/26726366/convert-nested-list-to-2d-array
        return history_reverse.stream()
                .map(h -> new String[] { h.getDate(), h.getDescription() })
                .toArray(String[][]::new);
    }
    
    public void addAmount(double amount) {
        balance += amount;
    }
    
    public void decreaseAmount(double amount) {
        balance -= amount;
    }
}
