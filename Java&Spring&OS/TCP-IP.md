# TCP/IP

#### TCP/IP

Four layers: 

1. Application layer
   * provides applications with standardized data exchange, such as HTTP, HTTPS, POP3
2. Transport layer
   * is responsible for maintaining end-to-end communications across the network
3. Internet layer
   * deals with packets and connects independent nectworks to transprot the packets across network boundaries
4. Link layer
   * consists of protocols that operate only a link - the network component that interconnects nodes or hosts in the network



#### TCP message types

|      MESSAGE      |                         DESCRIPTION                          |
| :---------------: | :----------------------------------------------------------: |
| SYN (Synchronize) | Used to initiate and establish a connection.<br> It also helps you to synchronize sequence numbers between devices |
| ACK (acknowledge) | Helps to confirm to the other side that it has received the SYN |
|      SYN-ACK      | SYN message from local device and ACK of the earlier packet  |
|    FIN (final)    |                Used to terminate a connection                |



#### TCP 3-way Handshake - Establish Connection

1. In the first step, the client establish a connection with a server. It sends a segment with SYN and informs the server about the client should start communication, and with what should be its sequence number
2. In this step, server responds to the client request with SYN-ACK signal set. ACK helps to signify the response of segment that is received and SYN signifies what sequence number it should able to start with the segments
3. In the final step, the client acknowledges the response of the server, and they both create a stable connection will begin the actual data transfer process



#### TCP 4-way Handshake - Terminate Connection

1. (**FIN From Client**) Client send a TCP segment with the FIN bit set to 1 to server and to enter the FIN_WAIT_1 state that the client waits for a TCP segment from the server with an ACK
2. (**ACK From Server**) When server received FIN bit segment from client, it immediately send ACK segment back
3. While in the FIN_WAIT_1 state, the client waits from a TCP segment from the server with an ACK. When it receives this segment, the client enters the FIN_WAIT_2 state that the clients waits for another segment for the server with the FIN bit set to 1
4. (**FIN From Server**) Server sends FIN bit segment to the client after some time when server send ACK
5. (**ACK From Client**) When client receive FIN bit segment from Server, the client acknowledges the server's segment and enters the TIME_WAIT state that lets the client resent the final ACK in case the ACK is lost.

#### IPv4

* The value of any segment is between 0 and 255, inclusively
* Address is divided into two parts: Network ID, Host ID

![img](https://media.geeksforgeeks.org/wp-content/cdn-uploads/IP_addressing_3.jpg)

#### Class A

* The network ID is 8 bits long
* The Host ID is 24 bits long
* 1.x.x.x - 126.x.x.x

![img](https://media.geeksforgeeks.org/wp-content/cdn-uploads/IP_addressing_4.jpg)

#### Class B

* 128.0.x.x - 191.255.x.x

![img](https://media.geeksforgeeks.org/wp-content/cdn-uploads/IP_addressing_5.jpg)

#### Class C

* 192.0.0.x - 223.255.255.x

![img](https://media.geeksforgeeks.org/wp-content/cdn-uploads/IP_addressing_6.jpg)

#### Class D - for multi-casting

* 224.0.0.0 - 239.255.255.255

![img](https://media.geeksforgeeks.org/wp-content/cdn-uploads/IP_addressing_7.jpg)

#### Class E - experimental and research purpose

* 240.0.0.0 - 255.255.255.254

![img](https://media.geeksforgeeks.org/wp-content/cdn-uploads/IP_addressing_8.jpg)

#### Rule for assigning Host ID

* Within any network, the host ID must be unique to that network
* Host ID in which all bits set to 0 cannot be assigned because this host ID is used to represent the network ID of the IP address
* Host ID in which all bits set to 1 cannot be assigned because this host ID is reserved as a broadcast address to send packets to all the hosts present on that particular network

#### Rule for assigning Network ID

* The network ID cannot start with 127 since it belongs to class A address and is reserved for internal loop-back functions
* All bits of network ID set to 1 are reserved for use as an IP broadcast address and therefore, cannot be used
* All bits of network set to 0 are used to denote a specific host on the local network and are not routed