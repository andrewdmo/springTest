#!/bin/bash
#AWS CLI SSH ver. 1
echo "Andy's first shell script"
echo "which should pipe in to:"

#change if/when needed
CURRENTURL=ec2-user@ec2-52-206-81-235.compute-1.amazonaws.com

echo $CURRENTURL

ssh -v -i ~/.ssh/aws-eb ec2-user@ec2-52-206-81-235.compute-1.amazonaws.com

echo "That just cost you money"