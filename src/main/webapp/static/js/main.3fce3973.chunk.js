(this["webpackJsonpplayoff-league-fe"]=this["webpackJsonpplayoff-league-fe"]||[]).push([[0],{123:function(e,t,a){e.exports=a(306)},128:function(e,t,a){},129:function(e,t,a){},130:function(e,t,a){},131:function(e,t,a){},132:function(e,t,a){},303:function(e,t,a){},306:function(e,t,a){"use strict";a.r(t);var n=a(0),r=a.n(n),l=a(21),i=a.n(l),c=(a(128),a(129),a(6)),s=a(10),o=a(11),m=a(13),u=a(12),d=a(7),f=a(14),h=(a(130),a(131),function(e){function t(e){var a;return Object(s.a)(this,t),(a=Object(m.a)(this,Object(u.a)(t).call(this,e))).state=void 0,a.state={x:Array()},["QB","RB","WR","TE","K","DST"].map((function(t){e.players.map((function(e){e.position===t&&a.state.x.push(e)}))})),a}return Object(f.a)(t,e),Object(o.a)(t,[{key:"componentDidMount",value:function(){this.setState({data:[]})}},{key:"getClazz",value:function(e){return void 0!=e.team2?"row text-left text-muted":void 0!=e.team1?"row text-left text-warning":"row text-left text-primary"}},{key:"render",value:function(){var e=this;return n.createElement("div",{className:""},this.state.x.map((function(t,a){return n.createElement("div",{className:e.getClazz(t)},n.createElement("div",{className:"col-2"},t.position),n.createElement("div",{className:"col-8"},t.name))})))}}]),t}(n.Component)),p=a(8),v=a.n(p),y=function(e){function t(e){var a;return Object(s.a)(this,t),(a=Object(m.a)(this,Object(u.a)(t).call(this,e))).state=void 0,a.state={nflTeams:[],players:[]},a.getPlayers=a.getPlayers.bind(Object(d.a)(a)),a}return Object(f.a)(t,e),Object(o.a)(t,[{key:"getPlayers",value:function(){var e=this;console.log("run"),fetch(window.name+"/player").then((function(e){return e.json()})).then((function(t){console.log(t),e.setState(Object(c.a)({},e.state,{players:t,nflTeams:e.state.nflTeams})),e.forceUpdate()}))}},{key:"componentDidMount",value:function(){var e=this;this.setState({nflTeams:[],isLoading:!0,players:[]}),fetch(window.name+"/player").then((function(e){return e.json()})).then((function(t){return e.setState({players:t,isLoading:!0,nflTeams:e.state.nflTeams}),fetch(window.name+"/static/nflTeams").then((function(e){return e.json()})).then((function(t){return e.setState({nflTeams:t,isLoading:!1,players:e.state.players})}))}))}},{key:"render",value:function(){var e=this;return n.createElement("div",{className:"container"},n.createElement("div",{className:"row"},v.a.filter(this.state.nflTeams,(function(e){return"AFC"===e.conf})).map((function(t,a){return n.createElement("div",{className:"col"},n.createElement("div",{className:"row "},n.createElement("h3",{className:"col-12"},t.name)),n.createElement("div",{className:"row"},n.createElement(h,{key:t.name,players:v.a.filter(e.state.players,(function(e){return e.nflTeam.name===t.name}))})))}))),n.createElement("div",{className:"row"},v.a.filter(this.state.nflTeams,(function(e){return"NFC"===e.conf})).map((function(t,a){return n.createElement("div",{className:"col"},n.createElement("div",{className:"row justify-content-center"},n.createElement("h3",null,t.name)),n.createElement("div",{className:""},n.createElement(h,{key:t.name,players:v.a.filter(e.state.players,(function(e){return e.nflTeam.name===t.name}))})))}))))}}]),t}(n.Component),E=(a(74),a(121)),b=a(22),k=function(e){function t(){return Object(s.a)(this,t),Object(m.a)(this,Object(u.a)(t).apply(this,arguments))}return Object(f.a)(t,e),Object(o.a)(t,[{key:"componentDidMount",value:function(){}},{key:"render",value:function(){return n.createElement("div",null,"Players")}}]),t}(n.Component),N=a(118),g=(a(132),a(34)),j=a(23),O=a(47),w=a(33),T=function(e){function t(e){var a;return Object(s.a)(this,t),(a=Object(m.a)(this,Object(u.a)(t).call(this,e))).state=void 0,a.state={teamName:"",teamEmail:"",teams:[]},a.handleChange=a.handleChange.bind(Object(d.a)(a)),a.handleSubmit=a.handleSubmit.bind(Object(d.a)(a)),a.randomDraft=a.randomDraft.bind(Object(d.a)(a)),a.deleteTeam=a.deleteTeam.bind(Object(d.a)(a)),a.getNeeds=a.getNeeds.bind(Object(d.a)(a)),a}return Object(f.a)(t,e),Object(o.a)(t,[{key:"loadTeams",value:function(){var e=this;fetch(window.name+"/team").then((function(e){return e.json()})).then((function(t){e.setState(Object(c.a)({},e.state,{teams:v.a.sortBy(t,"draftPos")}))}))}},{key:"componentDidMount",value:function(){this.loadTeams()}},{key:"handleSubmit",value:function(e){var t=this;console.log(this.state),e.preventDefault(),fetch(window.name+"/team",{method:"POST",body:JSON.stringify({name:this.state.teamName,email:this.state.teamEmail}),headers:{"Content-Type":"application/json"}}).then((function(e){return e.json()})).then((function(e){t.state.teams.push(e),t.setState(Object(c.a)({},t.state,{teams:v.a.sortBy(t.state.teams,"draftPos"),teamName:"",teamEmail:""}))})).catch((function(e){alert(e)}))}},{key:"handleChange",value:function(e){"name"===e.target.id&&this.setState(Object(c.a)({},this.state,{teamName:e.target.value})),"email"===e.target.id&&this.setState(Object(c.a)({},this.state,{teamEmail:e.target.value}))}},{key:"randomDraft",value:function(){var e=this;fetch(window.name+"/team/shuffle").then((function(e){return e.json()})).then((function(t){e.setState(Object(c.a)({},e.state,{teams:v.a.sortBy(t,"draftPos")}))}))}},{key:"deleteTeam",value:function(e){var t=this;fetch(window.name+"/team/"+e,{method:"DELETE"}).then((function(e){t.setState(Object(c.a)({},t.state,{teams:v.a.sortBy(e,"draftPos")}))}))}},{key:"startDraft",value:function(){fetch(window.name+"/draft/start",{method:"GET"}).then((function(e){alert("Draft is started , no mo teams can be added.")}))}},{key:"getNeeds",value:function(e){var t;if(t=["QB","RB","RB","WR/TE","WR/TE","WR/TE","K","DST"],console.log(e.players),e.players){var a=!0,n=!1,r=void 0;try{for(var l,i=e.players[Symbol.iterator]();!(a=(l=i.next()).done);a=!0){var c=l.value.position;"TE"!==c&&"WR"!=c||(c="WR/TE"),t.indexOf(c)>-1&&t.splice(t.indexOf(c),1)}}catch(s){n=!0,r=s}finally{try{a||null==i.return||i.return()}finally{if(n)throw r}}}return JSON.stringify(t)}},{key:"render",value:function(){var e=this;return n.createElement("div",{className:"row"},n.createElement(N.a,{size:"sm"},n.createElement("thead",null,n.createElement("tr",null,n.createElement("th",null,"Draft Pos"),n.createElement("th",null,"Name"),n.createElement("th",null,"email"),n.createElement("th",null,"remaining"),n.createElement("th",null,"util"))),n.createElement("tbody",null,this.state.teams.map((function(t,a){return n.createElement("tr",null,n.createElement("td",null,t.draftPos),n.createElement("td",null,t.name),n.createElement("td",null,t.email),n.createElement("td",null,e.getNeeds(t)),n.createElement("td",null,n.createElement(w.c,{onClick:function(){e.deleteTeam(t.id)}})))})))),n.createElement("div",{className:"row"}),n.createElement(g.a,{onSubmit:this.handleSubmit},n.createElement(g.a.Row,null,n.createElement(j.a,null,n.createElement(g.a.Control,{id:"name",type:"text",value:this.state.teamName,onChange:this.handleChange})),n.createElement(j.a,null,n.createElement(g.a.Control,{id:"email",type:"text",value:this.state.teamEmail,onChange:this.handleChange})),n.createElement(j.a,null,n.createElement(O.a,{variant:"primary",type:"submit"},"Add Team")),n.createElement(j.a,null,n.createElement(O.a,{variant:"primary",onClick:this.randomDraft},"shuffle draft")),n.createElement(j.a,null,n.createElement(O.a,{variant:"primary",onClick:this.startDraft},"Start draft")))))}}]),t}(n.Component),P=a(120),S=(a(303),function(e){function t(e){var a;return Object(s.a)(this,t),(a=Object(m.a)(this,Object(u.a)(t).call(this,e))).state=void 0,a.state=e,a}return Object(f.a)(t,e),Object(o.a)(t,[{key:"render",value:function(){var e=this;return n.createElement("div",{className:"row"},n.createElement("div",{className:"col-1"},this.state.pick.draftPos),n.createElement("div",{className:"col-1"},this.state.pick.roundPick),n.createElement("div",{className:"col-4"},this.state.pick.playerName),n.createElement("div",{className:"col-4"},this.state.pick.teamName),n.createElement("div",{className:"col-1"},n.createElement(w.a,{onClick:function(){e.state.editPick(e.state.pick.draftPos)}}),n.createElement(w.b,{onClick:function(){e.state.getNeeds(e.state.pick.teamId)}})))}}]),t}(n.Component)),C=function(e){function t(e){var a;return Object(s.a)(this,t),(a=Object(m.a)(this,Object(u.a)(t).call(this,e))).state=void 0,a.state={players:[],teams:[],picks:[],pickNumber:1,player:{position:"",id:0,name:"",nflTeam:{name:"",conf:"",logo:""},team1:void 0,team2:void 0}},a.handleChange=a.handleChange.bind(Object(d.a)(a)),a.handleSubmit=a.handleSubmit.bind(Object(d.a)(a)),a.editTeam=a.editTeam.bind(Object(d.a)(a)),a.getNeeds=a.getNeeds.bind(Object(d.a)(a)),a}return Object(f.a)(t,e),Object(o.a)(t,[{key:"loadTeams",value:function(){var e=this;fetch(window.name+"/team").then((function(e){return e.json()})).then((function(t){return e.setState(Object(c.a)({},e.state,{teams:v.a.sortBy(t,"draftPos")})),fetch(window.name+"/player").then((function(e){return e.json()})).then((function(t){return e.setState(Object(c.a)({},e.state,{players:t})),fetch(window.name+"/draft").then((function(e){return e.json()})).then((function(t){e.setState(Object(c.a)({},e.state,{picks:v.a.orderBy(t,["draftPos"]),pickNumber:e.getPickNumber(v.a.orderBy(t,["draftPos"]))}))}))}))}))}},{key:"getPickNumber",value:function(e){if(0===e.length)return 1;for(var t=!1,a=0;!t;)a==e.length&&(t=!0,a=0),0==e[a].playerId||void 0==e[a].playerId?t=!0:a+=1;return a+1}},{key:"componentDidMount",value:function(){this.loadTeams()}},{key:"handleSubmit",value:function(e){var t=this;fetch(window.name+"/draft/pick/"+this.state.picks[this.state.pickNumber-1].id+"?playerId="+this.state.player.id,{method:"PUT",headers:{"Content-Type":"application/json"}}).then((function(e){200==e.status?(t.state.picks[t.state.pickNumber-1].playerName=t.state.player.name,t.state.picks[t.state.pickNumber-1].playerId=t.state.player.id,t.setState(Object(c.a)({},t.state,{pickNumber:t.getPickNumber(t.state.picks)}))):alert("something"),console.log(e)})).catch((function(e){console.log(e)})),e.preventDefault()}},{key:"handleChange",value:function(e){this.setState(Object(c.a)({},this.state,{player:e[0]}))}},{key:"editTeam",value:function(e){this.setState(Object(c.a)({},this.state,{pickNumber:e}))}},{key:"getNeeds",value:function(e){this.state.teams.map((function(t){if(t.id.toString()==e){var a;if(a=["QB","RB","RB","WR/TE","WR/TE","WR/TE","K","DST"],console.log(t.players),t.players){var n=!0,r=!1,l=void 0;try{for(var i,c=t.players[Symbol.iterator]();!(n=(i=c.next()).done);n=!0){var s=i.value.position;"TE"!==s&&"WR"!=s||(s="WR/TE"),a.indexOf(s)>-1&&a.splice(a.indexOf(s),1)}}catch(o){r=!0,l=o}finally{try{n||null==c.return||c.return()}finally{if(r)throw l}}}alert(a)}}))}},{key:"render",value:function(){var e=this;return n.createElement("div",null,n.createElement("div",{className:"row"},n.createElement(g.a,{onSubmit:this.handleSubmit},n.createElement(g.a.Row,null,n.createElement(j.a,null,n.createElement(P.Typeahead,{id:"playersTypeAhead",labelKey:function(e){return e.name+"-"+e.position},filterBy:["name"],options:v.a.filter(this.state.players,(function(e){return!(void 0==e.team1&&void 0==e.team2)})),placeholder:"Player",onChange:this.handleChange})),n.createElement(j.a,null,n.createElement(O.a,{variant:"primary",type:"submit"},"Draft Player"))))),n.createElement("div",{className:"row"},n.createElement("div",{className:"col-1"},"pick#"),n.createElement("div",{className:"col-1"},"round.Pick"),n.createElement("div",{className:"col-4"},"Player"),n.createElement("div",{className:"col-4"},"Team"),n.createElement("div",{className:"col-2"},"Utils")),this.state.picks.map((function(t,a){return n.createElement("div",{className:e.state.pickNumber===t.draftPos?"pick":""},n.createElement(S,{pick:t,players:e.state.players,pickNumber:e.state.pickNumber,editPick:e.editTeam,getNeeds:e.getNeeds}))})))}}]),t}(n.Component),x=function(){return window.name="",r.a.createElement(E.a,null,r.a.createElement("div",{className:"App"},r.a.createElement("ul",{className:"nav nav-tabs"},r.a.createElement("li",{className:"nav-item"},r.a.createElement("a",{className:"nav-link active",href:"#"},"Draft Board")),r.a.createElement("li",{className:"nav-item"},r.a.createElement("a",{className:"nav-link",href:"/playerPage"},"Player Page")),r.a.createElement("li",{className:"nav-item"},r.a.createElement("a",{className:"nav-link",href:"/teamPage"},"Team Page")),r.a.createElement("li",{className:"nav-item"},r.a.createElement("a",{className:"nav-link",href:"/draftPage"},"Draft"))),r.a.createElement(b.c,null,r.a.createElement(b.a,{exact:!0,path:"/",component:k}),r.a.createElement(b.a,{exact:!0,path:"/playerPage",component:y}),r.a.createElement(b.a,{exact:!0,path:"/teamPage",component:T}),r.a.createElement(b.a,{exact:!0,path:"/draftPage",component:C}))))};Boolean("localhost"===window.location.hostname||"[::1]"===window.location.hostname||window.location.hostname.match(/^127(?:\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}$/));i.a.render(r.a.createElement(x,null),document.getElementById("root")),"serviceWorker"in navigator&&navigator.serviceWorker.ready.then((function(e){e.unregister()}))}},[[123,1,2]]]);
//# sourceMappingURL=main.3fce3973.chunk.js.map