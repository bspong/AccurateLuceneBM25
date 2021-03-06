/*
 * Copyright 2016 Carnegie Mellon University
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package qrels;
import java.util.*;

public class ResEntry implements Comparable<ResEntry> {
  public String               mDocId;
  public ArrayList<String>    mDocText;
  public float                mScore;
  
  public ResEntry(String docId, float score) {
    mDocId = docId;
    mScore = score;
    mDocText = null;
  }
  
  @SuppressWarnings("unchecked")
  public ResEntry(String docId, Object docText, float score) throws Exception {
    mDocId = docId;
    
    if (docText instanceof String) {
      mDocText = new ArrayList<String>();
      mDocText.add((String)docText);
    } else if (docText instanceof ArrayList) {
      mDocText = (ArrayList<String>)docText;
    } else {
      throw new Exception("Unknown type of the doc text: " + docText.getClass().getName());
    }
    mScore = score;
  }
  @Override
  public int compareTo(ResEntry o) {
    return mScore > o.mScore ? -1 : (mScore < o.mScore ? 1:0);
  }
};
