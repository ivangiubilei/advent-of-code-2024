⍝ Read the file content 
file_content ← ⎕NREAD 'data.txt' 

⍝ Blocks are separated by a newline character ('⍝')
lines ← file_content ⊸ { ⍵ } 

⍝ Convert each line to a numeric vector
lines ← ⍎¨ lines 

⍝ Function to check if array is monotonic
monotonic ← {(∧/¯1↓⍵<1⌽⍵) ∨ (∧/¯1↓⍵>1⌽⍵)}

⍝ Function to check if the distance between values is 3
distance <- {∧/3≥(¯1↓(1⌽⍵)-⍵)<0}

⍝ Apply the function to each line (and sums the output for each value)
results ← {+/(distance¨ ⍵ ∧ monotonic ⍵¨)} lines

⍝ Display the final results
results

⍝ 510


