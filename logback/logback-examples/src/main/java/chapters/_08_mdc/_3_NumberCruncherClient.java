/**
 * Logback: the reliable, generic, fast and flexible logging framework. Copyright (C) 1999-2015,
 * QOS.ch. All rights reserved.
 *
 * This program and the accompanying materials are dual-licensed under either the terms of the
 * Eclipse Public License v1.0 as published by the Eclipse Foundation
 *
 * or (per the licensee's choosing)
 *
 * under the terms of the GNU Lesser General Public License version 2.1 as published by the Free
 * Software Foundation.
 */
package chapters._08_mdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.RemoteException;

/**
 * NumberCruncherClient is a simple client for factoring integers. A remote NumberCruncher is
 * contacted and asked to factor an integer. The factors returned by the {@link
 * _3_NumberCruncherServer} are displayed on the screen.
 */
public class _3_NumberCruncherClient {

  public static void main(String[] args) {
    args = new String[]{"localhost"};
    try {
      String url = "rmi://" + args[0] + "/Factor";
      _3_NumberCruncher nc = (_3_NumberCruncher) Naming.lookup(url);
      loop(nc);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  static void usage(String msg) {
    System.err.println(msg);
    System.err.println("Usage: java chapters.mdc.NumberCruncherClient HOST\n"
        + "   where HOST is the machine where the NumberCruncherServer is running.");
    System.exit(1);
  }

  static void loop(_3_NumberCruncher nc) {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int i = 0;

    while (true) {
      System.out.print("Enter a number to factor, '-1' to quit: ");

      try {
        i = Integer.parseInt(in.readLine());
      } catch (Exception e) {
        e.printStackTrace();
      }

      if (i == -1) {
        System.out.print("Exiting loop.");

        return;
      } else {
        try {
          System.out.println("Will attempt to factor " + i);

          int[] factors = nc.factor(i);
          System.out.print("The factors of " + i + " are");

          for (int k = 0; k < factors.length; k++) {
            System.out.print(" " + factors[k]);
          }

          System.out.println(".");
        } catch (RemoteException e) {
          System.err.println("Could not factor " + i);
          e.printStackTrace();
        }
      }
    }
  }
}
