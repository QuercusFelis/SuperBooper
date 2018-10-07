package com.musicalpastries.superboopers.desktop;

import com.musicalpastries.superboopers.BScanner;
import com.musicalpastries.superboopers.SuperBoopers;

/**
 * loads - 4/13/2018.
 */

public class Scan implements BScanner {
    @Override
    public void scan() { }

    @Override
    public void tell(String lastScanned) {
        System.out.print(lastScanned);
    }
}
