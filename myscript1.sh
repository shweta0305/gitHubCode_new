#!/bin/bash
cd /home/shwetasingh/Git/
git clone $cloneURL
sleep 5
cd /home/shwetasingh/Git/$repoName
cp /home/shwetasingh/workspace/pageObject/f.txt /home/shwetasingh/Git/$repoName
git add .
git commit -m "initial commit"
git pull
git push https://shweta0305:ABCabc1994@github.com/shweta0305/$repoName.git




