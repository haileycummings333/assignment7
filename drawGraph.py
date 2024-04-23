import ast
import networkx as nx
import matplotlib.pyplot as plt
#watched youtube video: https://www.youtube.com/watch?v=x1UIYFMY2Xk&list=PLMtP8YtzV6HZ4-vRKp2OiQUYUf603zMBj


def create_graph(arr):
    G = nx.DiGraph()
    n = len(arr)

    # create the vertices of graph
    for v, x in arr:
        G.add_node(v)

    # create edges
    for i, (v, x) in enumerate(arr):
        left_vertex = arr[(i - x) % n][0]
        right_vertex = arr[(i + x) % n][0]
        G.add_edge(v, left_vertex)
        G.add_edge(v, right_vertex)

    return G

def draw_graph(G):
    pos = nx.spring_layout(G)

    # node colors
    node_colors = ['darkmagenta', 'slateblue', 'seagreen', 'burlywood', 'orchid', 'maroon']

    nx.draw(G, pos, with_labels=True, node_size=1750, font_color='white', font_size=16, font_weight="bold", node_color=node_colors)
    plt.show()

def main():
    input_str = "[ ('I', 2) , ('A', 5) , ('E', 4) , ('F',1) , ('T', 2) , ('S', 3) ]"
    input_pairs = ast.literal_eval(input_str)

    G = create_graph(input_pairs)
    draw_graph(G)

if __name__ == "__main__":
    main()
