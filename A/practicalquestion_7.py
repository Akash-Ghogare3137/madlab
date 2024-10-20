import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from sklearn.cluster import KMeans

# Load the dataset
data = pd.read_csv('Countries_dataset_1.csv')  # Replace with your actual file path

# Print the DataFrame to inspect its contents
print("DataFrame Head:")
print(data.head())

# Extract longitude and latitude for clustering
X = data[['Longitude', 'Latitude']]

# Set the number of clusters
K = 4

# Initialize and fit the K-means model
kmeans = KMeans(n_clusters=K, random_state=42)
kmeans.fit(X)

# Get cluster labels and centroids
data['Cluster'] = kmeans.labels_
centroids = kmeans.cluster_centers_

# Print final cluster means (centroids)
print("\nFinal Cluster Means (Centroids):")
print(centroids)

# Plotting the clusters
plt.figure(figsize=(10, 6))
plt.scatter(X['Longitude'], X['Latitude'], c=data['Cluster'], cmap='viridis', marker='o', label='Data Points')
plt.scatter(centroids[:, 0], centroids[:, 1], c='red', marker='X', s=200, label='Centroids')
plt.title('K-Means Clustering of Countries by Longitude and Latitude')
plt.xlabel('Longitude')
plt.ylabel('Latitude')
plt.legend()
plt.grid()
plt.show()
