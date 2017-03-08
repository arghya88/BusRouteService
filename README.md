# **BusRouteService**

MicroService for finding bus route.

# **Assumptions**
I assumed that if there is an edge between station id 3 and 6 then that also  means there is an edge between station id 6 and 3 and hence in the implementation I have created undirected graph.

If this assumption is not correct then I should be creating a directed graph and that can be done just by commenting out line 39,40 and 41 in DataLoader.java class.

# **Issues**

I tried running the service script.The PID in the pid file is not matching with the PID of the java process.So its not able to stop the java process.


# **How to use the service**

After the service started running hit below endpoint in your browser:

http://hostname:8088/api/direct?dep_sid=3&arr_sid=6
