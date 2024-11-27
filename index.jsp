<!DOCTYPE html>
<html>

<head>
    <title>Calculator</title>
    <style>
        body {
            font-family:sans-serif;
            display:flex;
            justify-content:center;
            align-items:center;
            height:100vh;
            margin:0;
            background-color:floralwhite;
        }

        .calculator {
            background-color:#333;
            border-radius:10px;
            box-shadow:0 4px 10px rgba(0, 0, 0, 0.1);
            width:260px;
            padding:20px;
            text-align:center;
        }

        .calculator input {
            background-color:#fff;
            border:none;
            border-radius:5px;
            width:90%;
            padding:10px;
            margin-bottom:15px;
            font-size:24px;
            text-align:right;
        }

        .calculator button {
            background-color:#444;
            border:none;
            border-radius:5px;
            color:white;
            font-size:18px;
            padding:15px;
            margin:5px;
            width:50px;
            cursor:pointer;
        }

    </style>
</head>
<%

%>

<body>
<div class="calculator">
    <input type="text" name="result" value="${exp}">
    <br>
    <form action="calcii" method="post">

        <button type="submit" name="button" value="1">1</button>
        <button type="submit" name="button" value="2">2</button>
        <button type="submit" name="button" value="3">3</button>
        <button type="submit" name="operator" value="+" class="operator">+</button>
        <br>
        <button type="submit" name="button" value="4">4</button>
        <button type="submit" name="button" value="5">5</button>
        <button type="submit" name="button" value="6">6</button>
        <button type="submit" name="operator" value="-" class="operator">-</button>
        <br>
        <button type="submit" name="button" value="7">7</button>
        <button type="submit" name="button" value="8">8</button>
        <button type="submit" name="button" value="9">9</button>
        <button type="submit" name="operator" value="*" class="operator">*</button>
        <br>
        <button type="submit" name="clear" value="clear" class="clear">C</button>
        <button type="submit" name="button" value="0">0</button>
        <button type="submit" name="calculate" value="equal" class="equal">=</button>
        <button type="submit" name="operator" value="%" class="operator">%</button>

    </form>

</div>
</body>

</html>
