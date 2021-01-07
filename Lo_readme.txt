{\rtf1\ansi\ansicpg1252\cocoartf1671\cocoasubrtf100
{\fonttbl\f0\fnil\fcharset0 Menlo-Regular;\f1\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;\red0\green0\blue0;\red47\green189\blue29;}
{\*\expandedcolortbl;;\csgray\c0;\cssrgb\c20011\c76928\c14710;}
\margl1440\margr1440\vieww10800\viewh8400\viewkind0
\pard\tx720\tx1440\tx2160\tx2880\tx3600\tx4320\tx5040\tx5760\tx6480\tx7200\tx7920\tx8640\pardirnatural\partightenfactor0

\f0\fs24 \cf0 Server side
\f1 \
\
\pard\tx560\tx1120\tx1680\tx2240\tx2800\tx3360\tx3920\tx4480\tx5040\tx5600\tx6160\tx6720\pardirnatural\partightenfactor0

\f0\fs22 \cf2 \CocoaLigature0 [loyi2374@goose ~]$ ls\
\pard\tx560\tx1120\tx1680\tx2240\tx2800\tx3360\tx3920\tx4480\tx5040\tx5600\tx6160\tx6720\pardirnatural\partightenfactor0
\cf3 Client.java\cf2    \cf3 Server.java\cf2     \cf3 TA.java\cf2         \cf3 TB.java\cf2 \
\cf3 Message.java\cf2   \cf3 TAHelper.java\cf2   \cf3 TBHelper.java\cf2 \
[loyi2374@goose ~]$ javac Server.java\
[loyi2374@goose ~]$ java Server\
input server's port number: \
3500\
\
Compile\
  javac Server.java\
\
Run\
  java Server\
  input server's port number: \
  3500\
\
\
\pard\tx560\tx1120\tx1680\tx2240\tx2800\tx3360\tx3920\tx4480\tx5040\tx5600\tx6160\tx6720\pardirnatural\partightenfactor0

\fs24 Client side\
\

\fs22 [loyi2374@hawk ~]$ ls\
\pard\tx560\tx1120\tx1680\tx2240\tx2800\tx3360\tx3920\tx4480\tx5040\tx5600\tx6160\tx6720\pardirnatural\partightenfactor0
\cf3 Client.java\cf2    \cf3 Server.java\cf2     \cf3 TA.java\cf2         \cf3 TB.java\cf2 \
\cf3 Message.java\cf2   \cf3 TAHelper.java\cf2   \cf3 TBHelper.java\cf2 \
[loyi2374@hawk ~]$ javac Client.java\
[loyi2374@hawk ~]$ java Client\
Enter address: \
goose.cs.qc.edu\
Enter port number: \
3500\
\
\
Compile\
  javac Client.java\
\
Run\
  java Client\
  Enter address: \
  hawk.cs.qc.edu\
  Enter port number: \
  3500\
}