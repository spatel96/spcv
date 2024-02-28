# Use a base image with GraalVM 21
FROM ghcr.io/graalvm/jdk-community:21

# Set the working directory inside the container
WORKDIR /app

# Copy the Micronaut application files into the container
COPY . /app

# Build the Micronaut application

# trunk-ignore(trivy/DS019)
RUN microdnf clean all; microdnf install findutils

RUN ./gradlew build

# Expose the port that your Micronaut application is running on
EXPOSE 8080

# Create a non-root user named "trunk"
RUN useradd -m -u 1001 spcv

# Change ownership of the application directory to the non-root user
RUN chown -R spcv /app

# Switch to the non-root user
USER spcv

HEALTHCHECK --interval=30s --timeout=30s --start-period=5s --retries=3 CMD [ "ping localhost:8080 -c 1" ]" ]

# Specify the command to run your application when the container starts
CMD ["./gradlew", "run"]
