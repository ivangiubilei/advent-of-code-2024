⍝ Read the file content 
file_content ← ⎕NREAD 'myfile.txt' 

⍝ Blocks are separated by a newline character ('⍝')
lines ← '⍝' 

⍝ Convert each line to a numeric vector
lines ← ⍎¨ lines 

⍝ Solution function (checks if function is monotonic)
f ← {(∧/¯1↓⍵<1⌽⍵) ∨ (∧/¯1↓⍵>1⌽⍵)}

⍝ Apply the function to each line within each block (and sums the output for each value)
results ← {+/f¨⍵}¨ lines

⍝ Display the final results
results

⍝ 510


