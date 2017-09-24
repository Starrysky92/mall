<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<#setting number_format="currency"/>
<#assign answer=42/>
${answer}
${answer?string} <#-- the same as ${answer} -->
${answer?string.number}
${answer?string.currency}
${answer?string.percent}
${answer}
</body>
</html>