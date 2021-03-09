# 1. 概念入门

**概念：** 
- GIT是一个分布式的版本控制工具：
    - 追踪变化：版本控制可以帮助我们在团队开发中记录何时，何地，何人对文件进行何种操作，且每次操作，版本号都会递增。
    - 协同修改：多人并行地修改服务器端的同一个文件。
    - 数据备份：记录当前和历史版本，方便版本回滚。
    - 权限控制：对参与开发的人员进行权限控制。
- GIT下载与安装：git属于傻瓜式安装。
    - **链接：** [官网下载地址](https://git-scm.com/download/win)
    - **链接：** [淘宝镜像下载](https://npm.taobao.org/mirrors/git-for-windows/)
    - 安装成功后使用cmd命令行键入 `git --version` 查看安装结果。

# 2. Git结构

**概念：** Git管理的文件总共分为如下区域：
- **工作区（Working tree）：** 你硬盘上的工作空间。
- **版本库（Repository）：** 又分为两个区域：
    - **暂存区（stage）：** 该区中的文件都是待提交状态，这个区主要负责提供后悔的机会。
    - **本地库分支（branch）：** 本地库分支默认使用master分支。

**流程：** Git命令行首次提交文件流程
1. 在工作区编写代码，如在D盘根目录下新建 `hello.txt`。
2. 在工作区目录（D:\）下右键选择 `Git Bash Here` 运行git命令行。
    - 这是一个git自带的命令行，支持linux命令。
    - `ll`：查看当前目录结构。    
    - `cat hello.txt`：查看文件内容
    - `vim hello.txt`：编辑文件内容
        - `i`：进入编辑模式。
        - `esc`：退出编辑模式。
        - `:wq`：保存并退出。
    - `clear`：清屏。
3. 通过 `git init` 初始化git仓库，此时目录中会生成一个 `.git` 文件夹。
4. 设置开发人员标识：必须设置否则某些命令会失效。
    - 局部设置：仅对当前本地库有效
        - 姓名标识：`git config user.name joezhou`
        - 邮箱标识：`git config user.email yy06200210@163.com`
        - 更改后在 `.git/config` 文件中查看。
    - 全局设置：对当前OS用户下的所有本地库有效（建议）
        - 姓名标识：`git config --global user.name joezhou`
        - 邮箱标识：`git config --global user.email yy06200210@163.com`
        - 更改后在OS用户文件夹下的 `.gitconfig` 文件中查看。
5. 通过 `git status` 查看当前工作区和暂存区状态：
    - 文件为红色表示文件在工作区中。
    - 文件为绿色表示文件在暂存区中。
6. 通过 `git add hello.txt` 命令将文件添加至暂存区：
    - linux相关警告可以忽略。
    - `git rm --cached hello.txt` 把暂存区最新版本转移回工作区。
7. 通过 `git commit -m "首次提交" hello.txt` 命令将暂存区文件，用户，日志消息等提交到本地库默认分支 `master` 中。
    - `rm hello.txt` 删除本地库分支的指定文件，可以使用 `git checkout hello.txt` 恢复删除文件。
    - `git rm hello.txt` 删除本库分支的指定文件，可以使用 `git reset <版本号>` 找回删除文件。
        - `git commit -m "删除了一些文件"` 确认删除需要执行一次不指定文件名的 `commit` 命令。
        - `git commit -m "删除了一些文件" -a`：确认删除工作区的一些红色文件。

## 2.1 回滚

**概念：** 如果你相对commit操作进行撤销，那么需要通过日志来回滚，只要在本地库发生commit操作，都会进行日志记录。
- `git log` 显示提交日志信息
    - `git log --pretty=oneline` 更优雅查看日志
    - `git log --oneline` 缩短了HASH字符串版本标识    
- `git reset --hard <版本号>` 将当前HEAD复位到指定的HASH字符串表示的状态
    - `--soft`：仅仅在本地库移动HEAD指针，工作区代码和暂存区代码会保持当前值。
    - `--mixed`：在本地库移动HEAD指针，工作区代码会保持当前值，但是暂存区会被覆盖。
    - `--hard`：在本地库移动HEAD指针，工作区代码和暂存区代码都会被覆盖。

## 2.2 文件比较

**概念：**
- `git diff start.txt` 查看工作区和暂存区指定文件的内容差异。
- `git diff --cached start.txt` 查看暂存区和仓库指定文件的内容差异。
- `git diff HEAD start.txt` 查看工作区和仓库指定文件的内容差异。
- `git diff` 不指定文件时表示比较所有文件。

> 如果一致就没什么提示了。

# 3. 远程库

**概念：** 远程库也叫代码托管中心，远程库可以使用局域网的 `GitLab` 服务器，也可以使用云端的 `GitHub` 或者 `GitEE`。

## 3.1 远程库GitHub

**概念：** 
- GitHub是用于版本控制和协作的代码托管平台，是一个开源的分布式的版本控制系统，只支持git这一种唯一版本库。
- GitHub从08年4月上线，一直到18年6月被微软收购。
- 登录 [GitHub官网](http://www.github.com) 注册GitHub账号并登录GitHub。
- 创建GitHub仓库：一个仓库对应一个项目。
    - 点击右上角头像左边的加号按钮，选择 `New Respsitory`
    - 填写仓库名 `Repository name`，建议和项目名同名（也可以不同名）。
    - 填写仓库描述 `Description`，可选。
    - 选择仓库访问权限：Private权限在2019年之前时收费的。
    - 勾选 `Initialize this repository with a README`，为你的项目生成一个README文件。
- GitHub是国外网站，比较慢，建议在 [DNS查询网](http://tool.chinaz.com/dns)中
    - 查询 `github.com` 复制TTL最快的。
    - 查询 `github.global.ssl.fastly.net` 复制TTL最快的。
    - 添加在 `C:\Windows\System32\drivers\etc\` 中的hosts文件末尾，如下：
    - 如果权限不够，点击host文件，右键属性-安全-编辑-选中当前登录的账号，对其勾选完全控制。
    - `ipconfig /flushdns`：刷新DNS配置。

```txt
140.82.113.3 github.com
151.101.109.194 github.global.ssl.fastly.net
```

## 3.2 从GitHub上clone项目到本地

**概念：** 你可以直接点击Download下载，但仍建议使用Git命令方式进行clone操作。

**流程：**
1. 复制远程库地址：`https://github.com/joe-zhou-hub/joe-start.git`
2. 在本地新建一个空白文件夹。
3. 在文件夹中右键开启Git命令行。
4. `git clone <远程地址>`
    - 该命令可以完整地将远程项目拷贝到本地。
    - 该命令可以自动完成了 `git init` 的工作。

## 3.3 从GitHub上pull项目到本地

1. `git pull origin master` 从远程获取最新版本并合并到本地，相当于依次执行如下两个命令：
    - `git fetch` 取回更新。
    - `git merge` 将更新内容合并到本地。
2. 如果远程库存在代码且和本地库无关联，会出现报错：
    - 报错内容：`refusing to merge unrelated histories`
    - 解决方案：`git pull origin master --allow-unrelated-histories`，该命令允许无关联合并。
    - 弹出的合并日志编辑器可以编写或直接 `:wq` 跳过。

## 3.4 使用Git命令行绑定远程库

**流程：**
1. 在Github上创建一个远程库 `joe-start`：
    - 远程库地址：`https://github.com/joe-zhou-hub/joe-start.git`
2. 在代码区编写文件start.txt，并且将文件提交到本地仓库分支上。
    - `git add start.txt`
    - `git commit -m "首次提交" start.txt`
3. 绑定远程仓库
    - `git remote add origin 远程路径`
    - `origin` 是远程仓库别名，随便起，建议默认。
4. 查看远程的仓库绑定信息
    - `git remote -v`
5. push操作之前需要先pull，保证数据一致性：
    - `git pull origin master --allow-unrelated-histories`
6. 将文件push到远程库 `origin` 的 `master` 分支上。
    - `git push -u origin master`
7. 填入用户名和密码。

## 3.5 分支

**概念：** 分支就是主干的一个克隆，分支可以保证安全，如果分支开发失败，删除不影响主干，还可以保证效率，多个分支一起并行工作，完成即可合并到主干。
- `git branch -v` 查看当前分支情况。
- `git branch hot_fix` 创建一个 `hot_fix` 分支。
- `git checkout hot_fix` 切换到 `hot_fix` 分支。
- 合并分支：
    - `git checkout master`：切换到主干分支上。
    - `git merge hot_fix`：将 `hot_fix` 分支合并到主干分支上。

> 建议不要在主干 `master` 上直接操作。
































