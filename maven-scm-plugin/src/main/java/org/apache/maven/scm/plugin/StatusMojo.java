package org.apache.maven.scm.plugin;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
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

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.scm.ScmException;
import org.apache.maven.scm.command.status.StatusScmResult;
import org.apache.maven.scm.repository.ScmRepository;

import java.io.IOException;

/**
 * @goal status
 * @description Project status
 *
 * @author <a href="evenisse@apache.org">Emmanuel Venisse</a>
 * @version $Id$
 */
public class StatusMojo
    extends AbstractScmMojo
{

    public void execute()
        throws MojoExecutionException
    {
        try
        {
            ScmRepository repository = getScmRepository();

            StatusScmResult result = getScmManager().status( repository, getFileSet() );

            checkResult( result );
        }
        catch ( IOException e )
        {
            throw new MojoExecutionException( "Cannot run checkout command : ", e );
        }
        catch ( ScmException e )
        {
            throw new MojoExecutionException( "Cannot run checkout command : ", e );
        }
    }

}
