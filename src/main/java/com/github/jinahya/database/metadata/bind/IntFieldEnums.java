/*
 * Copyright 2017 Jin Kwon &lt;onacit at wemakeprice.com&gt;.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.jinahya.database.metadata.bind;

final class IntFieldEnums {

    static <E extends Enum<E> & IntFieldEnum<E>> int[] rawValues(
            final Class<E> enumType) {
        final E[] enumConstants = enumType.getEnumConstants();
        final int[] rawValues = new int[enumConstants.length];
        for (int i = 0; i < rawValues.length; i++) {
            rawValues[i] = enumConstants[i].getRawValue();
        }
        return rawValues;
    }

    static <E extends Enum<E> & IntFieldEnum<E>> E valueOf(
            final Class<E> enumType, final int rawValue) {
        for (final E enumConstant : enumType.getEnumConstants()) {
            final int constantFieldValue = enumConstant.getRawValue();
            if (constantFieldValue == rawValue) {
                return enumConstant;
            }
        }
        throw new IllegalArgumentException("unknown raw value: " + rawValue);
    }

    // -------------------------------------------------------------------------    
    private IntFieldEnums() {
        super();
    }
}
