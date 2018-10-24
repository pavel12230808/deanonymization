<!DOCTYPE>

<html>

	<head>
		<title>[cytoscape.js-qtip.js] Cytoscape.js qTip</title>
		<h1>Accuracy:${val_acc}</h1>

		<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1, maximum-scale=1">

		<link rel="stylesheet" type="text/css" href="http://cdnjs.cloudflare.com/ajax/libs/qtip2/2.2.0/jquery.qtip.css">

		<script src="http://code.jquery.com/jquery-2.0.3.min.js"></script>
		<script src="http://cdnjs.cloudflare.com/ajax/libs/qtip2/2.2.0/jquery.qtip.js"></script>
		<script src="https://unpkg.com/cytoscape/dist/cytoscape.min.js"></script>
		<!-- <script src="../cytoscape.js/build/cytoscape.js"></script> -->

		<style>
			body, html {
				font-family: helvetica;
				font-size: 14px;
				width: 100%;
				height: 100%;
				position: absolute;
				padding: 0;
				margin: 0;
			}



            #cy2 {
                height: 100%;
                width: 100%;
                position: absolute;
                background-color: #EDF1FA;
                border-top: 1px solid #ccc;
            }
			h1 {
				opacity: 0.5;
				font-size: 1em;
				margin: 0.25em;
			}
		</style>


		<script>
			$(function(){
				  
                   var data_auxs = "${val_auxs}";
                   var oa = data_auxs.split(",");
                   var oan = data_auxs.split(",");
                   
                   console.log(oa);
                   
                   var data_auxd = "${val_auxd}";
                   var ob = data_auxd.split(",");
                   var obn = data_auxd.split(",");
                   
                   console.log(ob);
                   
                   var data_tars = "${val_tars}";
                   var a = data_tars.split(",");
                   var an = data_tars.split(",");
                   
                   console.log(a);
                   
                   var data_tard = "${val_tard}";
                   var b = data_tard.split(",");
                   var bn = data_tard.split(",");
                   
                   console.log(b);
                   
                   var data_matcha = "${val_matcha}";
                   var ma = data_matcha.split(",");
                   var man = data_matcha.split(",");
                   
                   console.log(ma);
                   
                   var data_matchd = "${val_matcht}";
                   var mb = data_matchd.split(",");
                   var mbn = data_matchd.split(",");
                   
                   console.log(mb);
                   
                   /*var a=["ja","ea","ka","ga","ja"];
                   var an=["ajerry","aelaine","akkramer","ageoe","ajerry"];

                   
                   var b=["ea","ka","jb","fb","jb"];
                   var bn=["aelaine","akkramer","bkane","bjerry","bjerry"];

                   var oa=["oja","oea","oka","oga","oja","vc","sr","ag"];
                   var oan=["ajerry","aelaine","akkramer","ageoe","ajerry","vchava","sravu","akiran"];

                   var ob=["oea","oka","ojb","ofb","ojb","gp","da","nm"]; //from auxd
                   var obn=["aelaine","akkramer","bjerry","bkane","bjerry","gputu","datluri","nmalam"];*/
                   //See here adil vai
                   // create 2 var for matched node between target and auxiliary graph like ma[] and mb[] and insert AuxiliaryUserID.txt and 
                   //TargergetUserID.txt in them

                  

                var cy2 = window.cy2 = cytoscape({
					container: document.getElementById('cy2'),
					ready: function(){
					},
					style: [
						{
							selector: 'node',
							css: {
								'content': 'data(name)',

                                'shape':'rectangle',
                                'background-opacity':0.5

							}
						},
						{
							selector: 'edge',

							css: {

								'target-arrow-shape': 'triangle',
                                'line-color': 'data(faveColor)',

							}
						},
                        {
							selector: 'node.node1',

							css: {

								 'background-color':'green'

							}
						},
                        {
							selector: 'node.node2',

							css: {

								 'background-color':'green'

							}
						},
                        {
							selector: 'node.onode1',

							css: {

								 'background-color':'brown'

							}
						},
                        {
							selector: 'node.onode2',

							css: {

								 'background-color':'brown'

							}
						},
                        {
							selector: 'edge.questionable',

							css: {
                                'line-color': 'data(faveColor)',
								'line-style': 'dashed',

							}
						}

					],




				});





                for (var i=0; i<oa.length; i++) {
                        var k = i;
                        var aid = oa[i];
                        var aname = oan[i];
                        var bid = ob[i];
                        var bname = obn[i];

                        cy2.add([
                        {group: "nodes", data: {id:aid, name:aname}, classes: 'onode1' },
                        {group: "nodes", data: {id:bid , name:bname}, classes: 'onode2' },
                        {group: "edges", data: {  source: oa[i], target: ob[i], faveColor: 'orange'}}
                        ])
                        }
                for (var i=0; i<a.length; i++) {
                        var k = i;
                        var aid = a[i];
                        var aname = an[i];
                        var bid = b[i];
                        var bname = bn[i];

                        cy2.add([
                        {group: "nodes", data: {id:aid, name:aname}, classes: 'node1' },
                        {group: "nodes", data: {id:bid , name:bname}, classes: 'node2' },
                        {group: "edges", data: {  source: a[i], target: b[i], faveColor: 'blue'}}
                        ])
                        }
                for(var i = 0; i<oa.length; i++){
                    //if("o"+oa[i] == a[i])
                    cy2.add([
						//See here Adil vai
						//change oa[] to ma[] and a[] to mb[]
                        {group: "edges", data: { source: ma[i], target: mb[i], faveColor: 'green'}, classes: 'questionable'}
                    ])
                }



												cy2.layout({
												name: 'circle'
												}).run();




			});

		</script>
	</head>

	<body>

        <div id="cy2"></div>
	</body>

</html>
