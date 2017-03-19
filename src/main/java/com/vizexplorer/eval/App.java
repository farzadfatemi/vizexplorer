/**
 * Copyright Notice Component
 * Our software code should contain a copyright notice to prevent an infringer from claiming that it did not know the code was protected under copyright.  The notice should look like this:
 * Copyright © 2008 - 2016 NEW BIS SAFE LUXCO S.Á.R.L
 * The copyright start date should represent the oldest elements in the code and the end date should represent the newest elements in the code.
 * <p>
 * Licensing Component
 * <p>
 * Under our standard VizExplorer license agreements we license our "Software".  "Software" has the definition below:
 * <p>
 * “Software” means: the VizExplorer client application and/or server application software (as applicable, and in executable form only) provided to Customer by Supplier or with Supplier’s written consent, and (i) all user guides, manuals and other user documentation relating to the Software (whether provided in hard-copy, electronically or on-line); (ii) all enhancements, modifications, updates, new releases that may, from time to time, be provided to Customer by Supplier or with Supplier’s written consent; and (iii) all additional VizExplorer software code (including, but not limited to, SQL interface code) but excluding all source code, that may, from time to time, be provided to Customer by Supplier or with Supplier’s written consent;
 * <p>
 * In addition our standard VizExplorer license agreement provides:
 * No license or subscription is granted for any source code and no license or right is granted to modify, adapt, create a derivative work, merge, or translate the Software without the prior written consent of Supplier.
 * Accordingly, VizExplorer does grant a license to the software in executable form, but does not grant a license for source code.
 * <p>
 * Intellectual Property Notice
 * Based on the above, I suggest the following generic Intellectual Property Notice:
 * <p>
 * “The following Intellectual Property Notice applies to all software code below and replaces any similar notice contained in this software.
 * INTELLECTUAL PROPERTY NOTICE
 * Copyright © 2008 - 2016 NEW BIS SAFE LUXCO S.Á.R.L
 * The VizExplorer software code below is a component of a VizExplorer software solution.
 * If the software code below is in non-source code executable form, then the code is licensed to you on the terms and conditions of VizExplorer’s standard End User License Agreement, a copy of which is located on VizExplorer’s website at: http://www.vizexplorer.com/license-agreements/.   By using the software code you agree that you have read and accepted the terms and conditions of VizExplorer’s standard End User License Agreement.
 * If the software code below is in source code form, no license or other permission is granted to you to use the software code."
 */
package com.vizexplorer.eval;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 *
 */
public class App {
    public static void main(String[] args) throws ParseException {
    /*  arg[1] = command{get(id) : get person with specific id};
     arg[1] = command{save(person data { name, gender, date of birth}) : save new person into database}
     arg[1] = command{update(person data {id, name, gender, date of birth}) : update existing person with its id }
     arg[1] = command{delete(id) : delete sepecific person with its id from database}
     arg[2] = id (for get,update and delete command) for save id has been ignored
     arg[3] = name
     arg[4] = gender
     arg[5] = date of birth
*/
        Date bd = null;
        try {
            if(args[5] !=null && !args[5].equals(""))
                bd = new SimpleDateFormat("yyyyMMdd").parse(args[5]);
            Person p = new Person(args[3], args[4], bd);
            switch (args[1]) {
                case "save":
                    PersonDAO.insertOrUpdatePerson(UUID.randomUUID().toString(), args[3], args[4], bd!=null?bd.toString():"");
                    break;
                case "update":
                    PersonDAO.insertOrUpdatePerson(args[2], args[3], args[4],  bd!=null?bd.toString():"");
                    break;
                case "delete":
                    PersonDAO.removePerson(args[2]);
                    break;
                case "get":
                    PersonDAO.getPerson(args[2]);
                    break;
            }
            System.out.println("Person instance created: " + p);
        } catch (Exception ex) {
            System.out.println("Date format is incorrect!!!");
//            ex.printStackTrace();
        }
    }
}
