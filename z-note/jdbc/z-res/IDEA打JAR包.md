**概念：** 如果对您的应用程序感到满意，您可能希望将其打包到Java存档（JAR）中进行分发，为此，您应该为JAR创建工件配置，然后构建工件。 

**流程：** 
1. `File` - `Project Structure` - `Project Settings` - `Artifacts`
2. 单击加号 - `JAR` - `From Modules with dependicies`
3. 在打开的对话框中指定jar包输出的位置，无需添加文件名。
4. 点击应用OK完成配置。
5. 回到主界面 - `Build` - `Build Artifacts`
6. 选择你的jar包，点击 `build`，完成jar包导出。

> 如果需要写README.txt等附属文件，需要在classpath下创建。