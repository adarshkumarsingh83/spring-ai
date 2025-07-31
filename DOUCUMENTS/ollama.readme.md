
 # ollama 

 ---

* to download 
 [download](https://ollama.com/download)

* to list the avaliable model 
 [models](https://ollama.com/search)

* $ ollama help
```
  serve       Start ollama
  create      Create a model
  show        Show information for a model
  run         Run a model
  stop        Stop a running model
  pull        Pull a model from a registry
  push        Push a model to a registry
  list        List models
  ps          List running models
  cp          Copy a model
  rm          Remove a model
  help        Help about any command
 ```
* ollama run deepseek-r1:1.5b
```
Use "ollama [command] --help" for more information about a command.
adarshkumar@adarshs-Mac-mini ~ % ollama run deepseek-r1:1.5b
pulling manifest 
pulling aabd4debf0c8: 100% ▕██████████████████▏ 1.1 GB                         
pulling c5ad996bda6e: 100% ▕██████████████████▏  556 B                         
pulling 6e4c38e1172f: 100% ▕██████████████████▏ 1.1 KB                         
pulling f4d24e9138dd: 100% ▕██████████████████▏  148 B                         
pulling a85fe2a2e58e: 100% ▕██████████████████▏  487 B                         
verifying sha256 digest 
writing manifest 
success 
>>> Send a



```
* to exit from chat 
````
>>> /bye
````

* $ ollama list 
```
NAME                ID              SIZE      MODIFIED      
deepseek-r1:1.5b    e0979632db5a    1.1 GB    5 minutes ago  
```

* ollama show deepseek-r1:1.5b
```
  Model
    architecture        qwen2     
    parameters          1.8B      
    context length      131072    
    embedding length    1536      
    quantization        Q4_K_M    

  Capabilities
    completion    
    thinking      

  Parameters
    stop    "<｜begin▁of▁sentence｜>"    
    stop    "<｜end▁of▁sentence｜>"      
    stop    "<｜User｜>"                 
    stop    "<｜Assistant｜>"            

  License
    MIT License                    
    Copyright (c) 2023 DeepSeek    
    ...                            

```

* ollama ps
```
NAME                ID              SIZE      PROCESSOR    CONTEXT    UNTIL              
deepseek-r1:1.5b    e0979632db5a    2.0 GB    100% GPU     4096       3 minutes from now    
```

* ollama stop deepseek-r1:1.5b
```
$ ollama ps                   
NAME    ID    SIZE    PROCESSOR    CONTEXT    UNTIL 
```

* ollama run deepseek-r1:1.5b                   
```
>>> Send a message (/? for help)

/bye 
```

* to access from rest api 
```
curl http://localhost:11434/api/generate -d '{
  "model": "deepseek-r1:1.5b",
  "prompt":"Why is the sky blue?"
}'
```

* to access from api chat 
```
curl http://localhost:11434/api/chat -d '{
  "model": "deepseek-r1:1.5b",
  "messages": [
    { "role": "user", "content": "why is the sky blue?" }
  ]
}'
```