player1 = input ( "select your choice for Roc pap scissor ").lower()
player2 = input ("select your choice for Roc pap scissor ").lower()
if player1 == player2 :
    print ("its tie")
elif (player1 == 'rock'):
    if (player2 == 'scissors'):
        print("player 1  wins")
    else:
        print ("player 2  wins")
elif (player1 == 'paper'):
    if (player2 == 'rock'):
        print("player 1  wins")
    else:
        print ("player 2  wins")
elif (player1 == 'scissors'):
    if (player2 == 'paper'):
        print("player  1  wins")
    else:
        print ("player 2  wins")
else:
    print("invalid input ! please enter valid input .")

play_again = input("Do you want to play again: ").lower()
if play_again != 'yes':
    print("thanks for playing")