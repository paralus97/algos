### Commands

Kernel is the inner core of the system. Shell provides an interface between end user and kernel. 

`whoami` prints currently logged in user

`pwd` prints current working directory

`mv <src> <dest>`

`cp <src> <dest>`

`cp can have -r argument also`

`less` same as cat except simplifies the large file browsing without going into vi

`tail` prints the end of the file. `tail -f` watches the file for changes and prints new appended data to the file. Like `tail -f rsyslog.3720 | grep "looking_for"`




`chown` changes the owner of a file or directory with `chown perikles: file.txt`

`sudo` runs a command as a superuser

`sudo -s` logs in your shell as a root user without having to do sudo

`clear` wipes the terminal buffer

`exit` quits the shell

`poweroff` and `reboot`

`history` print all ran commands in shell

`man` to see manpages such as `man clear` to show clear's manual pages



### File System

`/` root filesystem mount point

`/bin` contains common shared executables in the system

`/boot` linux kernel and linux boot configurations
 - `/grub` related to system booting, grub.cfg

`/dev` files that point to physical devices and pseudo devices
 - `s*` usually points to storage
 - `cat /dev/urandom` spams random numbers and is treated as a device

`/etc` system and program configuration files
 
`/home` personal directory for *non-root* users

`/lib`
`/lib32`
`/lib64` 
 - library files used by system like shared object files etc.

`/lost_found` 
 - fragmented files from the system due to save failures

`/media`
 - auto mounting place for certain external devices on some distros

`/mnt`
 - another mounting point for external media

`/opt`
 - various software, no real use but a common place to install software

`/proc` 
 - a folder for every process in the system. Virtual filesystem
 - `cat /proc/uptime` accesses output from uptime
 

`/root`
 - home directory for root user

`/sbin`
 - administrator runnables. like bin but for admins

`/tmp`
 - place for temporary files. gets wiped on reboot.

`/usr`
 - structured similarly to `/` but for custom software/changes/config

`/var`
 - contains all system logs


### Linux Processes

Processes are just applications executing some task on the system.
 - Has a process ID PID
 - Has a parent ID PPID (init process is first process, always has PID 1, parent id 0)

`ps -f 1` print init process. CMD shows PID, PPID, init system etc. When machine is booted, linux kernel starts up kernel space. When kernel space is initialised in kernel space, it calls systemd (init system) in user space. Systemd will then call and start all required processes in userspace

`ls -l` is a simple command. When it is run through a parent process like bash shell, the shell forks (splits into two) and the copy of itself is replaced by the `ls` program. This is called `fork and exec`. `fork` splits. `exec` replaces.

`ps` command is the base process information application. Run `sleep 360`. Terminal is inactive! What we can do is run `sleep 360` and hit Ctrl+Z to suspend process. Then run `ps` you will see process. Run `bg` and the process will run.We can also do this in one commang by doing `sleep 360 &`

`&` is key for background processes.

`jobs` will print user started processes. Use `bg %1` or `fg %2` to specify background or foregrounding process.

`ps az | grep sleep`

`kill` is used to kill processes. Use `kill -15 PID` sends SIGTERM to process, asks politely to close down process. SIGKILL hard closes and removes process `kill -9 PID`. `kill -l` shows all possible kill commands


### Linux Networking

`systemctl status NetworkManager.service` checks if network service is active and enabled. Prints light interface info

`ip a` prints info on all interfaces with an ip address

`ip route` prints ip routing information, gateway addresses

`nmcli` shows all this stuff too. Try `nmcli connection` for lighter info.

`ping` is good connectivity test

`nmtui` is a terminal ui for manually editing interface/connection details

 
