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

package com.pony.database.global;

/**
 * An interface that provides access to basic information about a BLOB so that
 * we may compare BLOBs implemented in different ways.
 *
 * @author Tobias Downer
 */

public interface BlobAccessor {

    /**
     * Returns the size of the BLOB.
     */
    int length();

    /**
     * Returns an InputStream that allows us to read the contents of the blob
     * from start to finish.  This object should be wrapped in a
     * BufferedInputStream if 'read()' type efficiency is required.
     */
    java.io.InputStream getInputStream();

}

