## 一、文件系统的管理 ##
**tips:**  输入命令的时候要常用tab键来补全

`ls`   查看目录信息  （ ls /  ）  
`ls -l` 等价于  `ll`
`pwd`	  查看当前所处的路径   
`cd`     切换目录 (cd /) ,如果不带参数则切换到用户主目录 ~
`mkdir`   创建文件夹  
`rmdir`   删除空文件夹  (只能删除空文件夹)    
`rm -r  /a/b`  (删除非空文件夹)

### 创建文件 ###
`touch a.avi` 创建一个空文件
`vi blabla.txt` 用文本编辑器编辑一个文件并且保存    
`echo "angelababy,zhen de hen xihuan ni" > qingshu.txt`  把左边的输出放到右边的文件里去 


#### 删除文件 ####
`rm filename`  (`rm -r`  删除文件夹     `rm -rf` 强制删除文件或文件夹) 
移动文件  修改文件名
`mv a/wenjian1.txt b/file1.txt`   (移动文件的同时还修改了文件名)  
拷贝文件`cp srcFile destFile`

#### 查看文件内容 ####
    cat wodeqingshu.txt
`more wodeqingshu.txt` 可以分页看    
`less wodeqingshu.txt` 不仅可以分页，还可以方便地搜索，回翻等操作    
`tail -10 wodeqingshu.txt`   查看文件的尾部的10行
程序打出的日志在生产实践中具有非凡的debug的意义  
`tail -f user.log`   实时刷新显示文件的尾部    
`head -20 wodeqingshu.txt` 查看文件的头部20行


## 二、权限管理 ##
    drwxrwxr-x

#### 修改权限 ####
`chmod  u+rwx file `  为file添加或取消所属用户的权限
(u代表所属用户  o代表其他用户  g代表所属组的成员用户)
`chmod 567 file` 用数字也可以表示权限  
5 --->  101 ---> r-x

修改文件的所有者owner`chown hadoop:hadoop  file`   
将file的所有者改成hadoop用户，所属组改成hadoop组    
上级目录的权限对本级文件或者文件夹的操作也有约束


## 三、用户管理 ##
#### 添加用户 ####
    useradd  itcast0830  

必须设置密码才能正常登陆    `passwd itcast0830`

#### 删除用户 ####
    userdel yun12
`userdel -r itcast `-----删除用户的同时删除用户的主目录

#### 修改用户属性 ####
`usermod -l b a` 将a的登陆名改为b      
`usermod -g hadoop itcast0830` 将itcast0830的组改为hadoop组  
`usermod -G hadoop,root itcast0830` 给itcast0830添加两个组hadoop,root     
`usermod -d /home/itcast itcast0830` 将itcast0830的主目录改成/home/itcast      
（要事先创建itcast目录，并且拷入环境变量文件）  
----****----修改用户的密码`passwd itcast0830 `  
添加用户组`groupadd beauties`   
删除用户组`groupdel beauties`   
修改用户组属性`groupmod `    
查看当前登陆的身份`whoami`  
查看当前用属的组`groups`


## 四、常见系统管理(凡是涉及到修改，就一定要用root权限) ##
****
轻易不要使用su去切换到root的身份
普通用户使用sudo来执行root权限的命令
如，将hadoop用户添加到sudoers文件中去

    root    ALL=(ALL)       ALL
    hadoop  ALL=(ALL)       ALL


#### 磁盘空间信息查看 ####

`df -h`  查看磁盘空间状态信息     
`du -sh *` 查看当前目录下所有子目录和文件的汇总大小    


#### 进程信息查看 ####

`free`  查看内存使用状况    
`top`   查看实时刷新的系统进程信息   
`ps -ef`  查看系统中当前瞬间的进程信息快照      
`ps -ef | grep myshell.sh`  搜索myshell进程的信息      
`kill -9 pid`  杀掉进程  （-9 表示强制杀死）


## 五、文件归档压缩(1：打包--归档； 2：压缩) ##
#### 1、归档 ####
    tar -cvf testdir.tar testdir/
#### 2、压缩 ####
    gzip testdir.tar
    gzip  file
    bzip  file 
    tar -czvf  testdir.tar.gz testdir/
`tar -xzvf testdir.tar.gz`  解压到当前目录下    
`tar -zxvf testdir.tar.gz -C Downloads/`   解压到指定的Downloads目录下




## 六、网络管理 ##
#### 修改ip地址的配置 ####
`vi /etc/sysconfig/network-scripts/ifcfg-eth0` 修改该配置文件即可改ip地址   
**或者用setup指令通过一个带提示的伪图形界面来修改**  
查看ip地址
    ifconfig

#### 修改主机名 ####
`vi  /etc/sysconfig/network`  修改其中的hostname配置项
要想立即生效  可以执行指令  `hostname nidezhujiming` 

    HOSTNAME=yun12-01

管理内网的主机名---ip地址映射

    vi /etc/hosts
    192.168.2.250  yun12-01


#### 重启网络服务 ####
root权限下   `service network restart`     
关闭防火墙服务  `service iptables stop`    
关闭防火墙自动启动   `chkconfig iptables off`    
修改系统的默认启动级别
    vi /etc/inittab

    #   0 - halt (Do NOT set initdefault to this)
    #   1 - Single user mode
    #   2 - Multiuser, without NFS (The same as 3, if you do not have networking)
    #   3 - Full multiuser mode
    #   4 - unused
    #   5 - X11
    #   6 - reboot (Do NOT set initdefault to this)
    #
    id:3:initdefault:
    ~
**用level 3 就启动全功能状态的字符界面** 



查看当前的进程连接网络的信息
`netstat -nltp `  





## 七、常用工具指令 ##
`wc`   统计文本信息（行数，词数，字符数）    
`date`  查看或者修改系统的日期和时间      
`echo`  输出字符串或者变量的值     
`vi`   linux系统中最通用的文本编辑器

## 八、linux中的软件安装  ##
**jdk**
将安装包解压到你的安装路径下  
`tar -xvf 压缩包 -C 目的地`   
然后修改环境变量  `sudo vi /etc/profile`    
然后  `source /etc/profile ` 来生效      
**tomcat  
Eclipse**   
**mysql**   
redhat 公司的RPM方式的包管理 也是很常用的软件包管理器

    rpm -qa | grep mysql
    sudo rpm -e mysql-libs-5.1.66-2.el6_3.i686 --nodeps
    sudo rpm -ivh MySQL-server-5.1.73-1.glibc23.i386.rpm 
    





