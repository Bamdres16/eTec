package com.tec.dispositivos;
	import java.util.List;
	import java.util.Queue;
	import java.util.PriorityQueue;
	import java.util.Deque;
	import java.util.LinkedList;
	import java.util.ArrayList;
	import java.util.Collections;

	
	public class DiGraph<T extends Comparable<T>>
	{
		public enum State { UNVISITED, VISITED, COMPLETE };

		private ArrayList<Vertex> vertices;
		private ArrayList<Edge> edges;

		public DiGraph()
		{
			vertices = new ArrayList<>();
			edges = new ArrayList<>();
		}

		public void add(T from, T to, int cost)
		{
			Edge temp = findEdge(from, to);
			if (temp != null)
			{
				System.out.println("Arista " + from + "," + to + " Ya existe. Cambie el costo");
				temp.cost = cost;
			}
			else
			{
				Edge e = new Edge(from, to, cost);
				edges.add(e);
			}
		}
		private Vertex findVertex(T v)
		{
			for (Vertex each : vertices)
			{
				if (each.value.compareTo(v)==0)
					return each;
			}
			return null;
		}

		private Edge findEdge(Vertex v1, Vertex v2)
		{
			for (Edge each : edges)
			{
				if (each.from.equals(v1) && each.to.equals(v2))
				{
					return each;
				}
			}
			return null;
		}

		
		private Edge findEdge(T from, T to)
		{
			for (Edge each : edges)
			{
				if (each.from.value.equals(from) && each.to.value.equals(to))
				{
					return each;
				}
			}
			return null;
		}

		
		private void clearStates()
		{
			for (Vertex each : vertices)
			{
				each.state = State.UNVISITED;
			}
		}

		public boolean isConnected()
		{
			for (Vertex each : vertices)
			{
				if (each.state != State.COMPLETE)
					return false;
			}
			return true;
		}

		public boolean DepthFirstSearch()
		{
			if (vertices.isEmpty()) return false;

			clearStates();
			Vertex root = vertices.get(0);
			if (root==null) return false;
			DepthFirstSearch(root);
			return isConnected();
		}

		private void DepthFirstSearch(Vertex v)
		{
			v.state = State.VISITED;

			// loop through neighbors
			for (Vertex each : v.outgoing)
			{
				if (each.state ==State.UNVISITED)
				{
					DepthFirstSearch(each);
				}
			}
			v.state = State.COMPLETE;
		}

		public boolean BreadthFirstSearch()
		{
			if (vertices.isEmpty()) return false;
			clearStates();

			Vertex root = vertices.get(0);
			if (root==null) return false;

			Queue<Vertex> queue = new LinkedList<>();
			queue.add(root);
			root.state = State.COMPLETE;

			while (!queue.isEmpty())
			{
				root = queue.peek();
				for (Vertex each : root.outgoing)
				{

					if (each.state==State.UNVISITED)
					{
						each.state = State.COMPLETE;
						queue.add(each);
					}
				}
				queue.remove();
			}
			return isConnected();
		}

		public boolean BreadthFirstSearch(T v1)
		{
			if (vertices.isEmpty()) return false;
			clearStates();

			Vertex root = findVertex(v1);
			if (root==null) return false;

			Queue<Vertex> queue = new LinkedList<>();
			queue.add(root);
			root.state = State.COMPLETE;

			while (!queue.isEmpty())
			{
				root = queue.peek();
				for (Vertex each : root.outgoing)
				{

					if (each.state==State.UNVISITED)
					{
						each.state = State.COMPLETE;
						queue.add(each);
					}
				}
				queue.remove();
			}
			return isConnected();
		}
		private boolean Dijkstra(T v1)
		{
			if (vertices.isEmpty()) return false;
			resetDistances();
		    Vertex source = findVertex(v1);
			if (source==null) return false;

			source.minDistance = 0;
			PriorityQueue<Vertex> pq = new PriorityQueue<>();
			pq.add(source);

			while (!pq.isEmpty())
			{
				Vertex u = pq.poll();
				for (Vertex v : u.outgoing)
				{
					Edge e = findEdge(u, v);
					if (e==null) return false;
					int totalDistance = u.minDistance + e.cost;
					if (totalDistance < v.minDistance)
					{
						pq.remove(v);
						v.minDistance = totalDistance;
						v.previous = u;
						pq.add(v);
					}
				}
			}
			return true;
		}

		private List<String> getShortestPath(Vertex target)
		{
			List<String> path = new ArrayList<String>();

			if (target.minDistance==Integer.MAX_VALUE)
			{
				path.add("direccion no encontrada");
				return path;
			}
			for (Vertex v = target; v !=null; v = v.previous)
			{
				path.add(v.value + " : costo : " + v.minDistance);
			}

			Collections.reverse(path);
			return path;
		}

		private void resetDistances()
		{
			for (Vertex each : vertices)
			{
				each.minDistance = Integer.MAX_VALUE;
				each.previous = null;
			}
		}
		public List<String> getPath(T from, T to)
		{
			boolean test = Dijkstra(from);
			if (test==false) return null;
			List<String> path = getShortestPath(findVertex(to));
			return path;
		}

		public String toString()
		{
			String retval = "";
			for (Vertex each : vertices)
			{
				retval += each.toString() + "\n";
			}
			return retval;
		}

		public String edgesToString()
		{
			String retval = "";
			for (Edge each : edges)
			{
				retval += each + "\n";
			}
			return retval;
		}


		class Vertex implements Comparable<Vertex>
		{
			T value;
			Vertex previous = null;
			int minDistance = Integer.MAX_VALUE;

			List<Vertex> incoming;
			List<Vertex> outgoing;
			State state;
			public Vertex(T value)
			{
				this.value = value;
				incoming = new ArrayList<>();
				outgoing = new ArrayList<>();
				state = State.UNVISITED;
			}

			@Override
			public int compareTo(Vertex other)
			{
				return Integer.compare(minDistance, other.minDistance);
			}

			
			public void addIncoming(Vertex vert)
			{
				incoming.add(vert);
			}
			public void addOutgoing(Vertex vert)
			{
				outgoing.add(vert);
			}

			@Override
			public String toString()
			{
				String retval = "";
				retval += "Vertice: " + value + " : ";
				retval += " In: ";
				for (Vertex each : incoming) retval+= each.value + " ";
				retval += "Salida: ";
				for (Vertex each : outgoing) retval += each.value + " ";
				return retval;
			}
		}

		class Edge
		{
			Vertex from;
			Vertex to;
			int cost;
			public Edge(T v1, T v2, int cost)
			{
				from = findVertex(v1);
				if (from == null)
				{
					from = new Vertex(v1);
					vertices.add(from);
				}
				to = findVertex(v2);
				if (to == null)
				{
					to = new Vertex(v2);
					vertices.add(to);
				}
				this.cost = cost;

				from.addOutgoing(to);
				to.addIncoming(from);
			}

			@Override
			public String toString()
			{
				return "Arista desde: " + from.value + " a: " + to.value + " costo: " + cost;
			}
		}
	}

