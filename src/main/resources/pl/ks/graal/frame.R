clazz <- java.type('javax.swing.JFrame')
frame <- new(clazz, "Title")
frame$setMinimumSize(new ('java.awt.Dimension', 100, 100))
frame$setVisible(TRUE)