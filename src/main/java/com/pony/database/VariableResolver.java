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

package com.pony.database;

/**
 * An interface to resolve a variable name to a constant object.  This is used
 * as a way to resolve a variable into a value to use in an expression.
 *
 * @author Tobias Downer
 */

public interface VariableResolver {

    /**
     * A number that uniquely identifies the current state of the variable
     * resolver.  This typically returns the row_index of the table we are
     * resolving variables on.
     */
    int setID();

    /**
     * Returns the value of a given variable.
     */
    TObject resolve(Variable variable);

    /**
     * Returns the TType of object the given variable is.
     */
    TType returnTType(Variable variable);

}
