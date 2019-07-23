package com.yesway.test;

import java.util.Arrays;

/**
 * Description: <><br>
 * Author:      mxdl<br>
 * Date:        2018/9/30<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class Bean {
    String[] arr;
    int[] len;

    @Override
    public String toString() {
        return "Bean{" + "arr=" + Arrays.toString(arr) + ", len=" + Arrays.toString(len) + '}';
    }
}
