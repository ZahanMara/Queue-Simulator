# Queue-Simulator
Design and implement a simulation application aiming to analyze queuing based systems for determining and minimizing clientsβ waiting time. 
Queues are commonly used to model real world domains. 
The main objective of a queue is to provide a place for a "client" to wait before receiving a "service". 
The management of queue-based system is interested in minimizing the time amount their "clients" are waiting in queues before they are served. 
One way to minimize the waiting time is to add more servers, i.e. more queues in the system (each queue is considered as having an associated processor) but this approach increases the costs of the service supplier. 
When a new server is added the waiting customers will be evenly distributed to all current available queues.

Data read from a text file for the application: 
-	Number of clients (N); 
-	Number of queues (Q); 
-	Simulation interval (π‘π πππ’πππ‘πππ ππ΄π ); 
-	Minimum and maximum arrival time (π‘πππππ£ππ ππΌπ β€ π‘πππππ£ππ β€ π‘πππππ£ππ ππ΄π ); 
-	Minimum and maximum service time (π‘π πππ£πππ ππΌπ β€ π‘π πππ£πππ β€ π‘π πππ£πππ ππ΄π )
Minimal output:
-	Queue evolution;
-	The waiting list of clients;
-	Average waiting time
