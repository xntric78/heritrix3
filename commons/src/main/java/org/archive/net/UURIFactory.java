/*
 *  This file is part of the Heritrix web crawler (crawler.archive.org).
 *
 *  Licensed to the Internet Archive (IA) by one or more individual 
 *  contributors. 
 *
 *  The IA licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.archive.net;

import org.apache.commons.httpclient.URIException;

public class UURIFactory extends org.archive.url.UsableURIFactory {
    
    private static final long serialVersionUID = -2615498094356088387L;
    
    /**
     * The single instance of this factory.
     */
    private static final UURIFactory factory = new UURIFactory();

    /**
     * @param uri URI as string.
     * @return An instance of UURI
     * @throws URIException
     */
    public static UURI getInstance(String uri) throws URIException {
        return (UURI) UURIFactory.factory.create(uri);
    }

    /**
     * @param base Base uri to use resolving passed relative uri.
     * @param relative URI as string.
     * @return An instance of UURI
     * @throws URIException
     */
    public static UURI getInstance(UURI base, String relative)
            throws URIException {
        return (UURI) UURIFactory.factory.create(base, relative);
    }

    protected UURI newUURI(String charset, boolean escaped, String fixedUpUri)
            throws URIException {
        return new UURI(fixedUpUri, escaped, charset);
    }

}
