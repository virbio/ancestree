/*
 * Copyright 2020 - Mathilde Foglierini Perez

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

   This class will connect to http://www.bioinf.org.uk/abs/abnum/
   using their web-servies interface.
   It will get the Kabat numbering from the heavy or light chain (prot)
 */

package ch.irb.kabat;

import java.io.IOException;
import java.util.TreeMap;





public class ProcessKabatNumbering {

    public ProcessKabatNumbering(String aaSequence) throws  IOException {
        throw new IOException("Contacting the Abnum website was removed.");
    }


    /**
     * @return the fromPositionToKabatnumbering
     */
    public TreeMap<Integer, String> getFromPositionToKabatnumbering() throws IOException {
        throw new IOException("Contacting the Abnum website was removed.");
    }
}
