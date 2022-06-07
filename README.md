# Testing_project
READ ME!
to run Gandalf's team testing project program on windows please follow the next steps:

1- Download code as zip from our github and extraact then open with intellij

2- Make sure that project has an sdk(16 is recommended) from file -> project structure -> project -> project sdk -> 16

3-add UCanAccess-5.0.1.bin and javafx sdk 11
note: to add library open file -> project structure -> libraries "+" top left and add the path of the library 
(the directory of project then inside of javafx sdk file the absolute path of "lib" folder)

4- jars should be added (found in libraries folder and in testfx_jar_files)
note: to add jar files open file -> project structure -> dependencies add "+" in the middle of the screen make sure to 
add the following jars in libraries 
1) gluton 
2) testfx_jar_files
3) UCanAccess

5- follow the steps in the following video to download java fx sdk add vm options:
link: https://www.youtube.com/watch?v=Ope4icw6bVk&list=PLZPZq0r_RZOM-8vJA3NQFZB7JroDcMwev&index=2
note:javafx sdk 11 is already present in the project libraries should be already added in step 3.  

note: when runing testfx(gui testing) sometimes intellij removes the add vm otions so this step may be required again to run program again
