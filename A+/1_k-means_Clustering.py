import numpy as np
from sklearn.datasets import load_iris
import random

# Load the Iris dataset
iris = load_iris()
data = iris.data

# Set parameters
K = 4
iterations = 10

# Randomly initialize cluster means (centroids)
random_indices = random.sample(range(data.shape[0]), K)
centroids = data[random_indices, :]

# Function to calculate Euclidean distance
def euclidean_distance(a, b):
    return np.linalg.norm(a - b)

# K-means clustering
for _ in range(iterations):
    # Assign clusters
    clusters = [[] for _ in range(K)]
    for point in data:
        distances = [euclidean_distance(point, centroid) for centroid in centroids]
        closest_centroid_index = np.argmin(distances)
        clusters[closest_centroid_index].append(point)

    # Update centroids
    for i in range(K):
        if clusters[i]:  # Avoid division by zero
            centroids[i] = np.mean(clusters[i], axis=0)

# Print final cluster means
for i, centroid in enumerate(centroids):
    print(f"Cluster {i+1} mean: {centroid}")

# pip install pandas
# pip install numpy
# pip install scikit-learn
# pip install matplotlib