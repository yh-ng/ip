# Duke project template

This is a project template for a greenfield Java project. It's named after the Java mascot _Duke_. Given below are instructions on how to use it.

## User Guide
### Command Words Supported
1. Create task:
   1. `todo`
      - Required format: `todo [description]`
   1. `event`
      - Required format: `event [description] /at [sometime]`
   1. `deadline`
      - Required format: `deadline [description] /by [sometime]`
1. View list of tasks: `list`
   - Required format: `list`
   - Returns a list of tasks
1. Mark task as done: `done` 
   - Required format: `done [task number in list]`
   - Task number must be less than or equal to total number of tasks 
1. Delete tasks: `delete`
   - Required format: `delete [task number in list]`
   - Task number must be less than or equal to total number of tasks 
1. Search for words: `find`
   - Required format: `find [single non-spaced word]`
1. `bye`
   - Terminates program

### Features
- The list of tasks saves to hard drive, but the data will not reflect if you have marked it as done. (See section **Bugs and Issues**)
- 

### Bugs and Issues
- If you mark a task as done, it does not save to hard drive. So if you close and open the app and look at the list, all the tasks will be marked as undone.
- Most errors are not handled. So if you write symbols like `\` instead of `/`, or do not follow the correct format for `event` or `deadline`, the app will crash.

## Setting up in Intellij

Prerequisites: JDK 11, update Intellij to the most recent version.

1. Open Intellij (if you are not in the welcome screen, click `File` > `Close Project` to close the existing project dialog first)
1. Set up the correct JDK version, as follows:
   1. Click `Configure` > `Structure for New Projects` and then `Project Settings` > `Project` > `Project SDK`
   1. If JDK 11 is listed in the drop down, select it. If it is not, click `New...` and select the directory where you installed JDK 11
   1. Click `OK`
1. Import the project into Intellij as follows:
   1. Click `Open or Import`.
   1. Select the project directory, and click `OK`
   1. If there are any further prompts, accept the defaults.
1. After the importing is complete, locate the `src/main/java/Duke.java` file, right-click it, and choose `Run Duke.main()`. If the setup is correct, you should see something like the below:
   ```
   Hello from
    ____        _        
   |  _ \ _   _| | _____ 
   | | | | | | | |/ / _ \
   | |_| | |_| |   <  __/
   |____/ \__,_|_|\_\___|
   ```
