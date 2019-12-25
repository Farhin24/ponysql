/*
 * Pony SQL Database ( http://www.ponysql.ru/ )
 * Copyright (C) 2019-2020 IllayDevel.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.pony.util;

import java.io.*;
import java.text.*;
import java.util.Date;

/**
 * A log file/stream that logs some information generated by the system.
 * This is intended to help with debugging.  It safely handles concurrent
 * output to the log.
 *
 * @author Tobias Downer
 */

public class Log {

    /**
     * The output stream where log information is output to.
     */
    private final LogWriter log_output;

    /**
     * Date formatter.
     */
    private final DateFormat date_format = DateFormat.getDateTimeInstance();


    public Log(String path) throws IOException {
        this(new File(path));
    }

    public Log(File file, int size, int max_count) throws IOException {
        this.log_output = new LogWriter(file, size, max_count);
    }

    public Log(File file) throws IOException {
        // Defaults to a maximum of 12 512k log files
        this(file, 512 * 1024, 12);
//    this.log_output = new LogWriter(file, 512 * 1024, 12);
    }

    protected Log() {
        log_output = null;
    }

    /**
     * Writes an entry to the log file.  The log file records the time the entry
     * was put into the log, and the string which is the log.
     */
    public synchronized void log(String text) {
        try {
            log_output.write("[");
            log_output.write(date_format.format(new Date()));
            log_output.write("] ");
            log_output.write(text);
            log_output.flush();
        } catch (IOException e) {
        }
    }

    public synchronized void logln(String text) {
        try {
            log_output.write(text);
            log_output.write('\n');
            log_output.flush();
        } catch (IOException e) {
        }
    }

    /**
     * Closes the log file.
     */
    public synchronized void close() {
        try {
            log_output.close();
        } catch (IOException e) {
        }
    }

    // ---------- Static methods ----------

    /**
     * Returns a Log that won't actually store a log.  This is useful for
     * options where the user doesn't want anything logged.
     */
    public static Log nullLog() {
        return new NullLog();
    }

    // ---------- Inner classes ----------

}

/**
 * An implementation of Log that doesn't log anything.
 */
class NullLog extends Log {

    public NullLog() {
        super();
    }

    public void log(String text) {
        // Don't do anything,
    }

    public void logln(String text) {
        // Don't do anything,
    }

    public void close() {
        // Don't do anything,
    }

}

