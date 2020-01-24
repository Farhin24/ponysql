/*
 * Pony SQL Database ( http://i-devel.ru )
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
 * A lightweight interface that is a reference to a blob in a BlobStore.  This
 * interface allows for data to be read and written to a blob.  Writing to a
 * blob may be restricted depending on the state setting of the blob.
 *
 * @author Tobias Downer
 */

public interface BlobRef extends BlobAccessor, Ref {

}

