@echo off
rem This script was automatically generated by makebat.
rem DO NOT EDIT.  Instead, edit ptinvoke.in, and run make.

set params=
:start
if "%1" == "" goto stop
set params=%params% %1
shift
goto start
:stop

"\usr\bin\javaw"  -Xmx512M "-Dptolemy.ptII.dir=/user/fviale/home/eclipse_workspace/ProActive_Latest/dev/matlab/src"    -classpath "/user/fviale/home/eclipse_workspace/ProActive_Latest/dev/matlab/src:/user/fviale/home/eclipse_workspace/ProActive_Latest/dev/matlab/src/lib/diva.jar@PTBACKTRACK_JARS@:/gdk.jar:/user/fviale/home/eclipse_workspace/ProActive_Latest/dev/matlab/src/lib/saxon8.jar:/user/fviale/home/eclipse_workspace/ProActive_Latest/dev/matlab/src/lib/saxon8-dom.jar:/user/fviale/home/eclipse_workspace/ProActive_Latest/dev/matlab/src/ptolemy/domains/ptinyos/lib/jdom.jar:/user/fviale/home/eclipse_workspace/ProActive_Latest/dev/matlab/src/ptolemy/domains/ptinyos/lib/nesc.jar" ptolemy.copernicus.kernel.Copernicus   %params%
pause
