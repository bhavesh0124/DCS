# Distribued-Computing-System-Codes

This repository contains some basic codes for distributed computing in JAVA. Distributed computing is a field of computer science that studies distributed systems. A distributed system is a system whose components are located on different networked computers, which 
communicate and coordinate their actions by passing messages to one another. 

The codes are based on client and server architectures.
1a,1b can be run on two different ways of communication and establising connection between the client and the server. These codes can be run on two different terminal windows.
      One will serve as client and other as producer.

3: Producer consumer
 
Bully.java  : the bully algorithm is a method for dynamically electing a coordinator or leader from a group of distributed computer processes. The process with the highest process ID number from amongst the non-failed processes is selected as the coordinator.
Ring.java : In this algorithm we assume that the link between the process are unidirectional and every process can message to the process on its right only. Data structure that this algorithm uses is active list, a list that has priority number of all active processes in the system.
