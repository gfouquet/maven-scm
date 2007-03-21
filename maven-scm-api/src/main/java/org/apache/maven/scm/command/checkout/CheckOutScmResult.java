package org.apache.maven.scm.command.checkout;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import org.apache.maven.scm.ScmResult;

import java.util.List;


/**
 * @author <a href="mailto:trygvis@inamo.no">Trygve Laugst&oslash;l</a>
 * @version $Id$
 */
public class CheckOutScmResult
    extends ScmResult
{

    private List checkedOutFiles;

    /**
     * The relative path of the directory of the checked out project in comparison to the checkout directory, or
     * an empty String in case the checkout directory equals the project directory.
     * <p/>
     * With most SCMs, this is just an empty String, meaning that the checkout directory equals the project directory.
     * But there are cases (e.g. ClearCase) where within the checkout directory, the directory structure of the
     * SCM system is repeated. E.g. if you check out the project "my/project" to "/some/dir", the project sources
     * are actually checked out to "my/project/some/dir". In this example, relativePathProjectDirectory would
     * contain "my/project".
     */
    protected String relativePathProjectDirectory = "";

    public CheckOutScmResult( String commandLine, String providerMessage, String commandOutput, boolean success )
    {
        super( commandLine, providerMessage, commandOutput, success );
    }

    public CheckOutScmResult( String commandLine, List checkedOutFiles )
    {
        super( commandLine, null, null, true );

        this.checkedOutFiles = checkedOutFiles;
    }

    public CheckOutScmResult( String commandLine, List checkedOutFiles, String relativePathProjectDirectory )
    {
        this( commandLine, checkedOutFiles );

        if ( relativePathProjectDirectory != null )
        {
            this.relativePathProjectDirectory = relativePathProjectDirectory;
        }
    }

    public CheckOutScmResult( List checkedOutFiles, ScmResult result )
    {
        super( result );

        this.checkedOutFiles = checkedOutFiles;
    }

    public List getCheckedOutFiles()
    {
        return checkedOutFiles;
    }

    /**
     * @return the contents of {@link #relativePathProjectDirectory}
     * @see #relativePathProjectDirectory
     */
    public String getRelativePathProjectDirectory()
    {
        return relativePathProjectDirectory;
    }
}
