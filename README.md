# **BusRouteService**

MicroService for finding bus route.

# **Assumptions**
I assumed that if there is an edge between station id 3 and 6 then that also  means there is an edge between station id 6 and 3 and hence in the implementation I have created undirected graph.

If this assumption is not correct then I should be creating a directed graph and that can be done just by commenting out line 39,40 and 41 in DataLoader.java class.

# **How to use the service**

After the service started running hit below endpoint in your browser:

http://hostname:8088/api/direct?dep_sid=3&arr_sid=6
