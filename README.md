# amino-acid-counter

A program that counts the frequency of each amino acid (and start and stop codons) in a given FASTA file for each of the 3 
reading frames.

This repo contains two versions of the same program, one is written using the MapReduce framework and the other is written
using the Spark framework.

The Spark version is slightly different as it creates three output files - one for each reading frame. While the MapReduce
program only creates one output.

Both programs are run using [MapR's Sandbox for Hadoop](https://mapr.com/products/mapr-sandbox-hadoop/download/).



### Credits
This program was an assignment for the CS185C: Solving Big Data Problems course taught by James Casaletto at 
San Jose State University.
