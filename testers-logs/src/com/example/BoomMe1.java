package com.example;

import com.example.BoomMeInternal;


public class BoomMe1
{
public static void main(String[] args)
{
new BoomMe1().boom();
}

private void boom()
{
while (true)
{
BoomMeInternal internal = new BoomMeInternal();
internal.boom();
}
}
}
