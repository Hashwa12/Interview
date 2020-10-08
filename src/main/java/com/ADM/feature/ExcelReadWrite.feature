Feature: To read data from sample_excelfile and write data to output_excelfile 

Scenario Outline:
Write data to excel from the values fetched from sample_excelfile 
	Given I locate the source file "<ReadPath>" and I confirm its name "sample_excelfile.xlsx" 
	Then I Start reading values from located file 
	And I write those values to the target file "<WritePath>"
	
	Examples: 
		|ReadPath|WritePath|
		|D:\\Hashwanth\\Interview\\others|D:\\Hashwanth\\Interview\\others\\output_excelfile.xlsx|