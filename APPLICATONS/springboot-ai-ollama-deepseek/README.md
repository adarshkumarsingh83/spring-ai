# SPRING BOOT AI OLLAMA DEEPSEEK 
---

[spring-ai-deepseek-doc](https://docs.spring.io/spring-ai/reference/api/chat/ollama-chat.html)

[step by step ollama guide](https://github.com/adarshkumarsingh83/spring-ai/blob/main/DOUCUMENTS/ollama.readme.md)
* To Run Ollama 
*  ollama run deepseek-r1:1.5b

---

## Api 
* curl -X GET http://localhost:9090/ai/generate/tell%20me%20joke
````
{"generation":"<think>\n\n</think>\n\nSure! Here's a light-hearted joke for you:\n\nWhy don’t skeletons fight each other?  \nBecause they don’t have the *guts*!  \n\n\uD83D\uDE04"}%                            
````

* curl -X GET http://localhost:9090/ai/generateStream/tell%20me%20joke
````
[
  {
    "result": {
      "output": {
        "messageType": "ASSISTANT",
        "metadata": {
          "messageType": "ASSISTANT"
        },
        "toolCalls": [],
        "media": [],
        "text": "<think>"
      },
      "metadata": {
        "finishReason": null,
        "contentFilters": [],
        "empty": true
      }
    },
    "results": [
      {
        "output": {
          "messageType": "ASSISTANT",
          "metadata": {
            "messageType": "ASSISTANT"
          },
          "toolCalls": [],
          "media": [],
          "text": "<think>"
        },
        "metadata": {
          "finishReason": null,
          "contentFilters": [],
          "empty": true
        }
      }
    ],
    "metadata": {
      "id": "",
      "model": "deepseek-r1:1.5b",
      "rateLimit": {
        "requestsLimit": 0,
        "requestsRemaining": 0,
        "requestsReset": "PT0S",
        "tokensRemaining": 0,
        "tokensLimit": 0,
        "tokensReset": "PT0S"
      },
      "usage": {
        "promptTokens": 0,
        "completionTokens": 0,
        "totalTokens": 0
      },
      "promptMetadata": [],
      "empty": false
    }
  },
  {
    "result": {
      "output": {
        "messageType": "ASSISTANT",
        "metadata": {
          "messageType": "ASSISTANT"
        },
        "toolCalls": [],
        "media": [],
        "text": "\n\n"
      },
      "metadata": {
        "finishReason": null,
        "contentFilters": [],
        "empty": true
      }
    },
    "results": [
      {
        "output": {
          "messageType": "ASSISTANT",
          "metadata": {
            "messageType": "ASSISTANT"
          },
          "toolCalls": [],
          "media": [],
          "text": "\n\n"
        },
        "metadata": {
          "finishReason": null,
          "contentFilters": [],
          "empty": true
        }
      }
    ],
    "metadata": {
      "id": "",
      "model": "deepseek-r1:1.5b",
      "rateLimit": {
        "requestsLimit": 0,
        "requestsRemaining": 0,
        "requestsReset": "PT0S",
        "tokensRemaining": 0,
        "tokensLimit": 0,
        "tokensReset": "PT0S"
      },
      "usage": {
        "promptTokens": 0,
        "completionTokens": 0,
        "totalTokens": 0
      },
      "promptMetadata": [],
      "empty": false
    }
  },
  {
    "result": {
      "output": {
        "messageType": "ASSISTANT",
        "metadata": {
          "messageType": "ASSISTANT"
        },
        "toolCalls": [],
        "media": [],
        "text": "</think>"
      },
      "metadata": {
        "finishReason": null,
        "contentFilters": [],
        "empty": true
      }
    },
    "results": [
      {
        "output": {
          "messageType": "ASSISTANT",
          "metadata": {
            "messageType": "ASSISTANT"
          },
          "toolCalls": [],
          "media": [],
          "text": "</think>"
        },
        "metadata": {
          "finishReason": null,
          "contentFilters": [],
          "empty": true
        }
      }
    ],
    "metadata": {
      "id": "",
      "model": "deepseek-r1:1.5b",
      "rateLimit": {
        "requestsLimit": 0,
        "requestsRemaining": 0,
        "requestsReset": "PT0S",
        "tokensRemaining": 0,
        "tokensLimit": 0,
        "tokensReset": "PT0S"
      },
      "usage": {
        "promptTokens": 0,
        "completionTokens": 0,
        "totalTokens": 0
      },
      "promptMetadata": [],
      "empty": false
    }
  },
  {
    "result": {
      "output": {
        "messageType": "ASSISTANT",
        "metadata": {
          "messageType": "ASSISTANT"
        },
        "toolCalls": [],
        "media": [],
        "text": "\n\n"
      },
      "metadata": {
        "finishReason": null,
        "contentFilters": [],
        "empty": true
      }
    },
    "results": [
      {
        "output": {
          "messageType": "ASSISTANT",
          "metadata": {
            "messageType": "ASSISTANT"
          },
          "toolCalls": [],
          "media": [],
          "text": "\n\n"
        },
        "metadata": {
          "finishReason": null,
          "contentFilters": [],
          "empty": true
        }
      }
    ],
    "metadata": {
      "id": "",
      "model": "deepseek-r1:1.5b",
      "rateLimit": {
        "requestsLimit": 0,
        "requestsRemaining": 0,
        "requestsReset": "PT0S",
        "tokensRemaining": 0,
        "tokensLimit": 0,
        "tokensReset": "PT0S"
      },
      "usage": {
        "promptTokens": 0,
        "completionTokens": 0,
        "totalTokens": 0
      },
      "promptMetadata": [],
      "empty": false
    }
  },
  {
    "result": {
      "output": {
        "messageType": "ASSISTANT",
        "metadata": {
          "messageType": "ASSISTANT"
        },
        "toolCalls": [],
        "media": [],
        "text": "Sure"
      },
      "metadata": {
        "finishReason": null,
        "contentFilters": [],
        "empty": true
      }
    },
    "results": [
      {
        "output": {
          "messageType": "ASSISTANT",
          "metadata": {
            "messageType": "ASSISTANT"
          },
          "toolCalls": [],
          "media": [],
          "text": "Sure"
        },
        "metadata": {
          "finishReason": null,
          "contentFilters": [],
          "empty": true
        }
      }
    ],
    "metadata": {
      "id": "",
      "model": "deepseek-r1:1.5b",
      "rateLimit": {
        "requestsLimit": 0,
        "requestsRemaining": 0,
        "requestsReset": "PT0S",
        "tokensRemaining": 0,
        "tokensLimit": 0,
        "tokensReset": "PT0S"
      },
      "usage": {
        "promptTokens": 0,
        "completionTokens": 0,
        "totalTokens": 0
      },
      "promptMetadata": [],
      "empty": false
    }
  },
  {
    "result": {
      "output": {
        "messageType": "ASSISTANT",
        "metadata": {
          "messageType": "ASSISTANT"
        },
        "toolCalls": [],
        "media": [],
        "text": "!"
      },
      "metadata": {
        "finishReason": null,
        "contentFilters": [],
        "empty": true
      }
    },
    "results": [
      {
        "output": {
          "messageType": "ASSISTANT",
          "metadata": {
            "messageType": "ASSISTANT"
          },
          "toolCalls": [],
          "media": [],
          "text": "!"
        },
        "metadata": {
          "finishReason": null,
          "contentFilters": [],
          "empty": true
        }
      }
    ],
    "metadata": {
      "id": "",
      "model": "deepseek-r1:1.5b",
      "rateLimit": {
        "requestsLimit": 0,
        "requestsRemaining": 0,
        "requestsReset": "PT0S",
        "tokensRemaining": 0,
        "tokensLimit": 0,
        "tokensReset": "PT0S"
      },
      "usage": {
        "promptTokens": 0,
        "completionTokens": 0,
        "totalTokens": 0
      },
      "promptMetadata": [],
      "empty": false
    }
  },
  {
    "result": {
      "output": {
        "messageType": "ASSISTANT",
        "metadata": {
          "messageType": "ASSISTANT"
        },
        "toolCalls": [],
        "media": [],
        "text": " Here"
      },
      "metadata": {
        "finishReason": null,
        "contentFilters": [],
        "empty": true
      }
    },
    "results": [
      {
        "output": {
          "messageType": "ASSISTANT",
          "metadata": {
            "messageType": "ASSISTANT"
          },
          "toolCalls": [],
          "media": [],
          "text": " Here"
        },
        "metadata": {
          "finishReason": null,
          "contentFilters": [],
          "empty": true
        }
      }
    ],
    "metadata": {
      "id": "",
      "model": "deepseek-r1:1.5b",
      "rateLimit": {
        "requestsLimit": 0,
        "requestsRemaining": 0,
        "requestsReset": "PT0S",
        "tokensRemaining": 0,
        "tokensLimit": 0,
        "tokensReset": "PT0S"
      },
      "usage": {
        "promptTokens": 0,
        "completionTokens": 0,
        "totalTokens": 0
      },
      "promptMetadata": [],
      "empty": false
    }
  },
  {
    "result": {
      "output": {
        "messageType": "ASSISTANT",
        "metadata": {
          "messageType": "ASSISTANT"
        },
        "toolCalls": [],
        "media": [],
        "text": "'s"
      },
      "metadata": {
        "finishReason": null,
        "contentFilters": [],
        "empty": true
      }
    },
    "results": [
      {
        "output": {
          "messageType": "ASSISTANT",
          "metadata": {
            "messageType": "ASSISTANT"
          },
          "toolCalls": [],
          "media": [],
          "text": "'s"
        },
        "metadata": {
          "finishReason": null,
          "contentFilters": [],
          "empty": true
        }
      }
    ],
    "metadata": {
      "id": "",
      "model": "deepseek-r1:1.5b",
      "rateLimit": {
        "requestsLimit": 0,
        "requestsRemaining": 0,
        "requestsReset": "PT0S",
        "tokensRemaining": 0,
        "tokensLimit": 0,
        "tokensReset": "PT0S"
      },
      "usage": {
        "promptTokens": 0,
        "completionTokens": 0,
        "totalTokens": 0
      },
      "promptMetadata": [],
      "empty": false
    }
  },
  {
    "result": {
      "output": {
        "messageType": "ASSISTANT",
        "metadata": {
          "messageType": "ASSISTANT"
        },
        "toolCalls": [],
        "media": [],
        "text": " a"
      },
      "metadata": {
        "finishReason": null,
        "contentFilters": [],
        "empty": true
      }
    },
    "results": [
      {
        "output": {
          "messageType": "ASSISTANT",
          "metadata": {
            "messageType": "ASSISTANT"
          },
          "toolCalls": [],
          "media": [],
          "text": " a"
        },
        "metadata": {
          "finishReason": null,
          "contentFilters": [],
          "empty": true
        }
      }
    ],
    "metadata": {
      "id": "",
      "model": "deepseek-r1:1.5b",
      "rateLimit": {
        "requestsLimit": 0,
        "requestsRemaining": 0,
        "requestsReset": "PT0S",
        "tokensRemaining": 0,
        "tokensLimit": 0,
        "tokensReset": "PT0S"
      },
      "usage": {
        "promptTokens": 0,
        "completionTokens": 0,
        "totalTokens": 0
      },
      "promptMetadata": [],
      "empty": false
    }
  },
  {
    "result": {
      "output": {
        "messageType": "ASSISTANT",
        "metadata": {
          "messageType": "ASSISTANT"
        },
        "toolCalls": [],
        "media": [],
        "text": " light"
      },
      "metadata": {
        "finishReason": null,
        "contentFilters": [],
        "empty": true
      }
    },
    "results": [
      {
        "output": {
          "messageType": "ASSISTANT",
          "metadata": {
            "messageType": "ASSISTANT"
          },
          "toolCalls": [],
          "media": [],
          "text": " light"
        },
        "metadata": {
          "finishReason": null,
          "contentFilters": [],
          "empty": true
        }
      }
    ],
    "metadata": {
      "id": "",
      "model": "deepseek-r1:1.5b",
      "rateLimit": {
        "requestsLimit": 0,
        "requestsRemaining": 0,
        "requestsReset": "PT0S",
        "tokensRemaining": 0,
        "tokensLimit": 0,
        "tokensReset": "PT0S"
      },
      "usage": {
        "promptTokens": 0,
        "completionTokens": 0,
        "totalTokens": 0
      },
      "promptMetadata": [],
      "empty": false
    }
  },
  {
    "result": {
      "output": {
        "messageType": "ASSISTANT",
        "metadata": {
          "messageType": "ASSISTANT"
        },
        "toolCalls": [],
        "media": [],
        "text": "-hearted"
      },
      "metadata": {
        "finishReason": null,
        "contentFilters": [],
        "empty": true
      }
    },
    "results": [
      {
        "output": {
          "messageType": "ASSISTANT",
          "metadata": {
            "messageType": "ASSISTANT"
          },
          "toolCalls": [],
          "media": [],
          "text": "-hearted"
        },
        "metadata": {
          "finishReason": null,
          "contentFilters": [],
          "empty": true
        }
      }
    ],
    "metadata": {
      "id": "",
      "model": "deepseek-r1:1.5b",
      "rateLimit": {
        "requestsLimit": 0,
        "requestsRemaining": 0,
        "requestsReset": "PT0S",
        "tokensRemaining": 0,
        "tokensLimit": 0,
        "tokensReset": "PT0S"
      },
      "usage": {
        "promptTokens": 0,
        "completionTokens": 0,
        "totalTokens": 0
      },
      "promptMetadata": [],
      "empty": false
    }
  },
  {
    "result": {
      "output": {
        "messageType": "ASSISTANT",
        "metadata": {
          "messageType": "ASSISTANT"
        },
        "toolCalls": [],
        "media": [],
        "text": " joke"
      },
      "metadata": {
        "finishReason": null,
        "contentFilters": [],
        "empty": true
      }
    },
    "results": [
      {
        "output": {
          "messageType": "ASSISTANT",
          "metadata": {
            "messageType": "ASSISTANT"
          },
          "toolCalls": [],
          "media": [],
          "text": " joke"
        },
        "metadata": {
          "finishReason": null,
          "contentFilters": [],
          "empty": true
        }
      }
    ],
    "metadata": {
      "id": "",
      "model": "deepseek-r1:1.5b",
      "rateLimit": {
        "requestsLimit": 0,
        "requestsRemaining": 0,
        "requestsReset": "PT0S",
        "tokensRemaining": 0,
        "tokensLimit": 0,
        "tokensReset": "PT0S"
      },
      "usage": {
        "promptTokens": 0,
        "completionTokens": 0,
        "totalTokens": 0
      },
      "promptMetadata": [],
      "empty": false
    }
  },
  {
    "result": {
      "output": {
        "messageType": "ASSISTANT",
        "metadata": {
          "messageType": "ASSISTANT"
        },
        "toolCalls": [],
        "media": [],
        "text": " for"
      },
      "metadata": {
        "finishReason": null,
        "contentFilters": [],
        "empty": true
      }
    },
    "results": [
      {
        "output": {
          "messageType": "ASSISTANT",
          "metadata": {
            "messageType": "ASSISTANT"
          },
          "toolCalls": [],
          "media": [],
          "text": " for"
        },
        "metadata": {
          "finishReason": null,
          "contentFilters": [],
          "empty": true
        }
      }
    ],
    "metadata": {
      "id": "",
      "model": "deepseek-r1:1.5b",
      "rateLimit": {
        "requestsLimit": 0,
        "requestsRemaining": 0,
        "requestsReset": "PT0S",
        "tokensRemaining": 0,
        "tokensLimit": 0,
        "tokensReset": "PT0S"
      },
      "usage": {
        "promptTokens": 0,
        "completionTokens": 0,
        "totalTokens": 0
      },
      "promptMetadata": [],
      "empty": false
    }
  },
  {
    "result": {
      "output": {
        "messageType": "ASSISTANT",
        "metadata": {
          "messageType": "ASSISTANT"
        },
        "toolCalls": [],
        "media": [],
        "text": " you"
      },
      "metadata": {
        "finishReason": null,
        "contentFilters": [],
        "empty": true
      }
    },
    "results": [
      {
        "output": {
          "messageType": "ASSISTANT",
          "metadata": {
            "messageType": "ASSISTANT"
          },
          "toolCalls": [],
          "media": [],
          "text": " you"
        },
        "metadata": {
          "finishReason": null,
          "contentFilters": [],
          "empty": true
        }
      }
    ],
    "metadata": {
      "id": "",
      "model": "deepseek-r1:1.5b",
      "rateLimit": {
        "requestsLimit": 0,
        "requestsRemaining": 0,
        "requestsReset": "PT0S",
        "tokensRemaining": 0,
        "tokensLimit": 0,
        "tokensReset": "PT0S"
      },
      "usage": {
        "promptTokens": 0,
        "completionTokens": 0,
        "totalTokens": 0
      },
      "promptMetadata": [],
      "empty": false
    }
  },
  {
    "result": {
      "output": {
        "messageType": "ASSISTANT",
        "metadata": {
          "messageType": "ASSISTANT"
        },
        "toolCalls": [],
        "media": [],
        "text": ":\n\n"
      },
      "metadata": {
        "finishReason": null,
        "contentFilters": [],
        "empty": true
      }
    },
    "results": [
      {
        "output": {
          "messageType": "ASSISTANT",
          "metadata": {
            "messageType": "ASSISTANT"
          },
          "toolCalls": [],
          "media": [],
          "text": ":\n\n"
        },
        "metadata": {
          "finishReason": null,
          "contentFilters": [],
          "empty": true
        }
      }
    ],
    "metadata": {
      "id": "",
      "model": "deepseek-r1:1.5b",
      "rateLimit": {
        "requestsLimit": 0,
        "requestsRemaining": 0,
        "requestsReset": "PT0S",
        "tokensRemaining": 0,
        "tokensLimit": 0,
        "tokensReset": "PT0S"
      },
      "usage": {
        "promptTokens": 0,
        "completionTokens": 0,
        "totalTokens": 0
      },
      "promptMetadata": [],
      "empty": false
    }
  },
  {
    "result": {
      "output": {
        "messageType": "ASSISTANT",
        "metadata": {
          "messageType": "ASSISTANT"
        },
        "toolCalls": [],
        "media": [],
        "text": "Why"
      },
      "metadata": {
        "finishReason": null,
        "contentFilters": [],
        "empty": true
      }
    },
    "results": [
      {
        "output": {
          "messageType": "ASSISTANT",
          "metadata": {
            "messageType": "ASSISTANT"
          },
          "toolCalls": [],
          "media": [],
          "text": "Why"
        },
        "metadata": {
          "finishReason": null,
          "contentFilters": [],
          "empty": true
        }
      }
    ],
    "metadata": {
      "id": "",
      "model": "deepseek-r1:1.5b",
      "rateLimit": {
        "requestsLimit": 0,
        "requestsRemaining": 0,
        "requestsReset": "PT0S",
        "tokensRemaining": 0,
        "tokensLimit": 0,
        "tokensReset": "PT0S"
      },
      "usage": {
        "promptTokens": 0,
        "completionTokens": 0,
        "totalTokens": 0
      },
      "promptMetadata": [],
      "empty": false
    }
  },
  {
    "result": {
      "output": {
        "messageType": "ASSISTANT",
        "metadata": {
          "messageType": "ASSISTANT"
        },
        "toolCalls": [],
        "media": [],
        "text": " don"
      },
      "metadata": {
        "finishReason": null,
        "contentFilters": [],
        "empty": true
      }
    },
    "results": [
      {
        "output": {
          "messageType": "ASSISTANT",
          "metadata": {
            "messageType": "ASSISTANT"
          },
          "toolCalls": [],
          "media": [],
          "text": " don"
        },
        "metadata": {
          "finishReason": null,
          "contentFilters": [],
          "empty": true
        }
      }
    ],
    "metadata": {
      "id": "",
      "model": "deepseek-r1:1.5b",
      "rateLimit": {
        "requestsLimit": 0,
        "requestsRemaining": 0,
        "requestsReset": "PT0S",
        "tokensRemaining": 0,
        "tokensLimit": 0,
        "tokensReset": "PT0S"
      },
      "usage": {
        "promptTokens": 0,
        "completionTokens": 0,
        "totalTokens": 0
      },
      "promptMetadata": [],
      "empty": false
    }
  },
  {
    "result": {
      "output": {
        "messageType": "ASSISTANT",
        "metadata": {
          "messageType": "ASSISTANT"
        },
        "toolCalls": [],
        "media": [],
        "text": "’t"
      },
      "metadata": {
        "finishReason": null,
        "contentFilters": [],
        "empty": true
      }
    },
    "results": [
      {
        "output": {
          "messageType": "ASSISTANT",
          "metadata": {
            "messageType": "ASSISTANT"
          },
          "toolCalls": [],
          "media": [],
          "text": "’t"
        },
        "metadata": {
          "finishReason": null,
          "contentFilters": [],
          "empty": true
        }
      }
    ],
    "metadata": {
      "id": "",
      "model": "deepseek-r1:1.5b",
      "rateLimit": {
        "requestsLimit": 0,
        "requestsRemaining": 0,
        "requestsReset": "PT0S",
        "tokensRemaining": 0,
        "tokensLimit": 0,
        "tokensReset": "PT0S"
      },
      "usage": {
        "promptTokens": 0,
        "completionTokens": 0,
        "totalTokens": 0
      },
      "promptMetadata": [],
      "empty": false
    }
  },
  {
    "result": {
      "output": {
        "messageType": "ASSISTANT",
        "metadata": {
          "messageType": "ASSISTANT"
        },
        "toolCalls": [],
        "media": [],
        "text": " skeletons"
      },
      "metadata": {
        "finishReason": null,
        "contentFilters": [],
        "empty": true
      }
    },
    "results": [
      {
        "output": {
          "messageType": "ASSISTANT",
          "metadata": {
            "messageType": "ASSISTANT"
          },
          "toolCalls": [],
          "media": [],
          "text": " skeletons"
        },
        "metadata": {
          "finishReason": null,
          "contentFilters": [],
          "empty": true
        }
      }
    ],
    "metadata": {
      "id": "",
      "model": "deepseek-r1:1.5b",
      "rateLimit": {
        "requestsLimit": 0,
        "requestsRemaining": 0,
        "requestsReset": "PT0S",
        "tokensRemaining": 0,
        "tokensLimit": 0,
        "tokensReset": "PT0S"
      },
      "usage": {
        "promptTokens": 0,
        "completionTokens": 0,
        "totalTokens": 0
      },
      "promptMetadata": [],
      "empty": false
    }
  },
  {
    "result": {
      "output": {
        "messageType": "ASSISTANT",
        "metadata": {
          "messageType": "ASSISTANT"
        },
        "toolCalls": [],
        "media": [],
        "text": " fight"
      },
      "metadata": {
        "finishReason": null,
        "contentFilters": [],
        "empty": true
      }
    },
    "results": [
      {
        "output": {
          "messageType": "ASSISTANT",
          "metadata": {
            "messageType": "ASSISTANT"
          },
          "toolCalls": [],
          "media": [],
          "text": " fight"
        },
        "metadata": {
          "finishReason": null,
          "contentFilters": [],
          "empty": true
        }
      }
    ],
    "metadata": {
      "id": "",
      "model": "deepseek-r1:1.5b",
      "rateLimit": {
        "requestsLimit": 0,
        "requestsRemaining": 0,
        "requestsReset": "PT0S",
        "tokensRemaining": 0,
        "tokensLimit": 0,
        "tokensReset": "PT0S"
      },
      "usage": {
        "promptTokens": 0,
        "completionTokens": 0,
        "totalTokens": 0
      },
      "promptMetadata": [],
      "empty": false
    }
  },
  {
    "result": {
      "output": {
        "messageType": "ASSISTANT",
        "metadata": {
          "messageType": "ASSISTANT"
        },
        "toolCalls": [],
        "media": [],
        "text": " each"
      },
      "metadata": {
        "finishReason": null,
        "contentFilters": [],
        "empty": true
      }
    },
    "results": [
      {
        "output": {
          "messageType": "ASSISTANT",
          "metadata": {
            "messageType": "ASSISTANT"
          },
          "toolCalls": [],
          "media": [],
          "text": " each"
        },
        "metadata": {
          "finishReason": null,
          "contentFilters": [],
          "empty": true
        }
      }
    ],
    "metadata": {
      "id": "",
      "model": "deepseek-r1:1.5b",
      "rateLimit": {
        "requestsLimit": 0,
        "requestsRemaining": 0,
        "requestsReset": "PT0S",
        "tokensRemaining": 0,
        "tokensLimit": 0,
        "tokensReset": "PT0S"
      },
      "usage": {
        "promptTokens": 0,
        "completionTokens": 0,
        "totalTokens": 0
      },
      "promptMetadata": [],
      "empty": false
    }
  },
  {
    "result": {
      "output": {
        "messageType": "ASSISTANT",
        "metadata": {
          "messageType": "ASSISTANT"
        },
        "toolCalls": [],
        "media": [],
        "text": " other"
      },
      "metadata": {
        "finishReason": null,
        "contentFilters": [],
        "empty": true
      }
    },
    "results": [
      {
        "output": {
          "messageType": "ASSISTANT",
          "metadata": {
            "messageType": "ASSISTANT"
          },
          "toolCalls": [],
          "media": [],
          "text": " other"
        },
        "metadata": {
          "finishReason": null,
          "contentFilters": [],
          "empty": true
        }
      }
    ],
    "metadata": {
      "id": "",
      "model": "deepseek-r1:1.5b",
      "rateLimit": {
        "requestsLimit": 0,
        "requestsRemaining": 0,
        "requestsReset": "PT0S",
        "tokensRemaining": 0,
        "tokensLimit": 0,
        "tokensReset": "PT0S"
      },
      "usage": {
        "promptTokens": 0,
        "completionTokens": 0,
        "totalTokens": 0
      },
      "promptMetadata": [],
      "empty": false
    }
  },
  {
    "result": {
      "output": {
        "messageType": "ASSISTANT",
        "metadata": {
          "messageType": "ASSISTANT"
        },
        "toolCalls": [],
        "media": [],
        "text": "?"
      },
      "metadata": {
        "finishReason": null,
        "contentFilters": [],
        "empty": true
      }
    },
    "results": [
      {
        "output": {
          "messageType": "ASSISTANT",
          "metadata": {
            "messageType": "ASSISTANT"
          },
          "toolCalls": [],
          "media": [],
          "text": "?"
        },
        "metadata": {
          "finishReason": null,
          "contentFilters": [],
          "empty": true
        }
      }
    ],
    "metadata": {
      "id": "",
      "model": "deepseek-r1:1.5b",
      "rateLimit": {
        "requestsLimit": 0,
        "requestsRemaining": 0,
        "requestsReset": "PT0S",
        "tokensRemaining": 0,
        "tokensLimit": 0,
        "tokensReset": "PT0S"
      },
      "usage": {
        "promptTokens": 0,
        "completionTokens": 0,
        "totalTokens": 0
      },
      "promptMetadata": [],
      "empty": false
    }
  },
  {
    "result": {
      "output": {
        "messageType": "ASSISTANT",
        "metadata": {
          "messageType": "ASSISTANT"
        },
        "toolCalls": [],
        "media": [],
        "text": "  \n"
      },
      "metadata": {
        "finishReason": null,
        "contentFilters": [],
        "empty": true
      }
    },
    "results": [
      {
        "output": {
          "messageType": "ASSISTANT",
          "metadata": {
            "messageType": "ASSISTANT"
          },
          "toolCalls": [],
          "media": [],
          "text": "  \n"
        },
        "metadata": {
          "finishReason": null,
          "contentFilters": [],
          "empty": true
        }
      }
    ],
    "metadata": {
      "id": "",
      "model": "deepseek-r1:1.5b",
      "rateLimit": {
        "requestsLimit": 0,
        "requestsRemaining": 0,
        "requestsReset": "PT0S",
        "tokensRemaining": 0,
        "tokensLimit": 0,
        "tokensReset": "PT0S"
      },
      "usage": {
        "promptTokens": 0,
        "completionTokens": 0,
        "totalTokens": 0
      },
      "promptMetadata": [],
      "empty": false
    }
  },
  {
    "result": {
      "output": {
        "messageType": "ASSISTANT",
        "metadata": {
          "messageType": "ASSISTANT"
        },
        "toolCalls": [],
        "media": [],
        "text": "Because"
      },
      "metadata": {
        "finishReason": null,
        "contentFilters": [],
        "empty": true
      }
    },
    "results": [
      {
        "output": {
          "messageType": "ASSISTANT",
          "metadata": {
            "messageType": "ASSISTANT"
          },
          "toolCalls": [],
          "media": [],
          "text": "Because"
        },
        "metadata": {
          "finishReason": null,
          "contentFilters": [],
          "empty": true
        }
      }
    ],
    "metadata": {
      "id": "",
      "model": "deepseek-r1:1.5b",
      "rateLimit": {
        "requestsLimit": 0,
        "requestsRemaining": 0,
        "requestsReset": "PT0S",
        "tokensRemaining": 0,
        "tokensLimit": 0,
        "tokensReset": "PT0S"
      },
      "usage": {
        "promptTokens": 0,
        "completionTokens": 0,
        "totalTokens": 0
      },
      "promptMetadata": [],
      "empty": false
    }
  },
  {
    "result": {
      "output": {
        "messageType": "ASSISTANT",
        "metadata": {
          "messageType": "ASSISTANT"
        },
        "toolCalls": [],
        "media": [],
        "text": " they"
      },
      "metadata": {
        "finishReason": null,
        "contentFilters": [],
        "empty": true
      }
    },
    "results": [
      {
        "output": {
          "messageType": "ASSISTANT",
          "metadata": {
            "messageType": "ASSISTANT"
          },
          "toolCalls": [],
          "media": [],
          "text": " they"
        },
        "metadata": {
          "finishReason": null,
          "contentFilters": [],
          "empty": true
        }
      }
    ],
    "metadata": {
      "id": "",
      "model": "deepseek-r1:1.5b",
      "rateLimit": {
        "requestsLimit": 0,
        "requestsRemaining": 0,
        "requestsReset": "PT0S",
        "tokensRemaining": 0,
        "tokensLimit": 0,
        "tokensReset": "PT0S"
      },
      "usage": {
        "promptTokens": 0,
        "completionTokens": 0,
        "totalTokens": 0
      },
      "promptMetadata": [],
      "empty": false
    }
  },
  {
    "result": {
      "output": {
        "messageType": "ASSISTANT",
        "metadata": {
          "messageType": "ASSISTANT"
        },
        "toolCalls": [],
        "media": [],
        "text": " don"
      },
      "metadata": {
        "finishReason": null,
        "contentFilters": [],
        "empty": true
      }
    },
    "results": [
      {
        "output": {
          "messageType": "ASSISTANT",
          "metadata": {
            "messageType": "ASSISTANT"
          },
          "toolCalls": [],
          "media": [],
          "text": " don"
        },
        "metadata": {
          "finishReason": null,
          "contentFilters": [],
          "empty": true
        }
      }
    ],
    "metadata": {
      "id": "",
      "model": "deepseek-r1:1.5b",
      "rateLimit": {
        "requestsLimit": 0,
        "requestsRemaining": 0,
        "requestsReset": "PT0S",
        "tokensRemaining": 0,
        "tokensLimit": 0,
        "tokensReset": "PT0S"
      },
      "usage": {
        "promptTokens": 0,
        "completionTokens": 0,
        "totalTokens": 0
      },
      "promptMetadata": [],
      "empty": false
    }
  },
  {
    "result": {
      "output": {
        "messageType": "ASSISTANT",
        "metadata": {
          "messageType": "ASSISTANT"
        },
        "toolCalls": [],
        "media": [],
        "text": "’t"
      },
      "metadata": {
        "finishReason": null,
        "contentFilters": [],
        "empty": true
      }
    },
    "results": [
      {
        "output": {
          "messageType": "ASSISTANT",
          "metadata": {
            "messageType": "ASSISTANT"
          },
          "toolCalls": [],
          "media": [],
          "text": "’t"
        },
        "metadata": {
          "finishReason": null,
          "contentFilters": [],
          "empty": true
        }
      }
    ],
    "metadata": {
      "id": "",
      "model": "deepseek-r1:1.5b",
      "rateLimit": {
        "requestsLimit": 0,
        "requestsRemaining": 0,
        "requestsReset": "PT0S",
        "tokensRemaining": 0,
        "tokensLimit": 0,
        "tokensReset": "PT0S"
      },
      "usage": {
        "promptTokens": 0,
        "completionTokens": 0,
        "totalTokens": 0
      },
      "promptMetadata": [],
      "empty": false
    }
  },
  {
    "result": {
      "output": {
        "messageType": "ASSISTANT",
        "metadata": {
          "messageType": "ASSISTANT"
        },
        "toolCalls": [],
        "media": [],
        "text": " have"
      },
      "metadata": {
        "finishReason": null,
        "contentFilters": [],
        "empty": true
      }
    },
    "results": [
      {
        "output": {
          "messageType": "ASSISTANT",
          "metadata": {
            "messageType": "ASSISTANT"
          },
          "toolCalls": [],
          "media": [],
          "text": " have"
        },
        "metadata": {
          "finishReason": null,
          "contentFilters": [],
          "empty": true
        }
      }
    ],
    "metadata": {
      "id": "",
      "model": "deepseek-r1:1.5b",
      "rateLimit": {
        "requestsLimit": 0,
        "requestsRemaining": 0,
        "requestsReset": "PT0S",
        "tokensRemaining": 0,
        "tokensLimit": 0,
        "tokensReset": "PT0S"
      },
      "usage": {
        "promptTokens": 0,
        "completionTokens": 0,
        "totalTokens": 0
      },
      "promptMetadata": [],
      "empty": false
    }
  },
  {
    "result": {
      "output": {
        "messageType": "ASSISTANT",
        "metadata": {
          "messageType": "ASSISTANT"
        },
        "toolCalls": [],
        "media": [],
        "text": " the"
      },
      "metadata": {
        "finishReason": null,
        "contentFilters": [],
        "empty": true
      }
    },
    "results": [
      {
        "output": {
          "messageType": "ASSISTANT",
          "metadata": {
            "messageType": "ASSISTANT"
          },
          "toolCalls": [],
          "media": [],
          "text": " the"
        },
        "metadata": {
          "finishReason": null,
          "contentFilters": [],
          "empty": true
        }
      }
    ],
    "metadata": {
      "id": "",
      "model": "deepseek-r1:1.5b",
      "rateLimit": {
        "requestsLimit": 0,
        "requestsRemaining": 0,
        "requestsReset": "PT0S",
        "tokensRemaining": 0,
        "tokensLimit": 0,
        "tokensReset": "PT0S"
      },
      "usage": {
        "promptTokens": 0,
        "completionTokens": 0,
        "totalTokens": 0
      },
      "promptMetadata": [],
      "empty": false
    }
  },
  {
    "result": {
      "output": {
        "messageType": "ASSISTANT",
        "metadata": {
          "messageType": "ASSISTANT"
        },
        "toolCalls": [],
        "media": [],
        "text": " *"
      },
      "metadata": {
        "finishReason": null,
        "contentFilters": [],
        "empty": true
      }
    },
    "results": [
      {
        "output": {
          "messageType": "ASSISTANT",
          "metadata": {
            "messageType": "ASSISTANT"
          },
          "toolCalls": [],
          "media": [],
          "text": " *"
        },
        "metadata": {
          "finishReason": null,
          "contentFilters": [],
          "empty": true
        }
      }
    ],
    "metadata": {
      "id": "",
      "model": "deepseek-r1:1.5b",
      "rateLimit": {
        "requestsLimit": 0,
        "requestsRemaining": 0,
        "requestsReset": "PT0S",
        "tokensRemaining": 0,
        "tokensLimit": 0,
        "tokensReset": "PT0S"
      },
      "usage": {
        "promptTokens": 0,
        "completionTokens": 0,
        "totalTokens": 0
      },
      "promptMetadata": [],
      "empty": false
    }
  },
  {
    "result": {
      "output": {
        "messageType": "ASSISTANT",
        "metadata": {
          "messageType": "ASSISTANT"
        },
        "toolCalls": [],
        "media": [],
        "text": "g"
      },
      "metadata": {
        "finishReason": null,
        "contentFilters": [],
        "empty": true
      }
    },
    "results": [
      {
        "output": {
          "messageType": "ASSISTANT",
          "metadata": {
            "messageType": "ASSISTANT"
          },
          "toolCalls": [],
          "media": [],
          "text": "g"
        },
        "metadata": {
          "finishReason": null,
          "contentFilters": [],
          "empty": true
        }
      }
    ],
    "metadata": {
      "id": "",
      "model": "deepseek-r1:1.5b",
      "rateLimit": {
        "requestsLimit": 0,
        "requestsRemaining": 0,
        "requestsReset": "PT0S",
        "tokensRemaining": 0,
        "tokensLimit": 0,
        "tokensReset": "PT0S"
      },
      "usage": {
        "promptTokens": 0,
        "completionTokens": 0,
        "totalTokens": 0
      },
      "promptMetadata": [],
      "empty": false
    }
  },
  {
    "result": {
      "output": {
        "messageType": "ASSISTANT",
        "metadata": {
          "messageType": "ASSISTANT"
        },
        "toolCalls": [],
        "media": [],
        "text": "irth"
      },
      "metadata": {
        "finishReason": null,
        "contentFilters": [],
        "empty": true
      }
    },
    "results": [
      {
        "output": {
          "messageType": "ASSISTANT",
          "metadata": {
            "messageType": "ASSISTANT"
          },
          "toolCalls": [],
          "media": [],
          "text": "irth"
        },
        "metadata": {
          "finishReason": null,
          "contentFilters": [],
          "empty": true
        }
      }
    ],
    "metadata": {
      "id": "",
      "model": "deepseek-r1:1.5b",
      "rateLimit": {
        "requestsLimit": 0,
        "requestsRemaining": 0,
        "requestsReset": "PT0S",
        "tokensRemaining": 0,
        "tokensLimit": 0,
        "tokensReset": "PT0S"
      },
      "usage": {
        "promptTokens": 0,
        "completionTokens": 0,
        "totalTokens": 0
      },
      "promptMetadata": [],
      "empty": false
    }
  },
  {
    "result": {
      "output": {
        "messageType": "ASSISTANT",
        "metadata": {
          "messageType": "ASSISTANT"
        },
        "toolCalls": [],
        "media": [],
        "text": "*"
      },
      "metadata": {
        "finishReason": null,
        "contentFilters": [],
        "empty": true
      }
    },
    "results": [
      {
        "output": {
          "messageType": "ASSISTANT",
          "metadata": {
            "messageType": "ASSISTANT"
          },
          "toolCalls": [],
          "media": [],
          "text": "*"
        },
        "metadata": {
          "finishReason": null,
          "contentFilters": [],
          "empty": true
        }
      }
    ],
    "metadata": {
      "id": "",
      "model": "deepseek-r1:1.5b",
      "rateLimit": {
        "requestsLimit": 0,
        "requestsRemaining": 0,
        "requestsReset": "PT0S",
        "tokensRemaining": 0,
        "tokensLimit": 0,
        "tokensReset": "PT0S"
      },
      "usage": {
        "promptTokens": 0,
        "completionTokens": 0,
        "totalTokens": 0
      },
      "promptMetadata": [],
      "empty": false
    }
  },
  {
    "result": {
      "output": {
        "messageType": "ASSISTANT",
        "metadata": {
          "messageType": "ASSISTANT"
        },
        "toolCalls": [],
        "media": [],
        "text": "!\n\n"
      },
      "metadata": {
        "finishReason": null,
        "contentFilters": [],
        "empty": true
      }
    },
    "results": [
      {
        "output": {
          "messageType": "ASSISTANT",
          "metadata": {
            "messageType": "ASSISTANT"
          },
          "toolCalls": [],
          "media": [],
          "text": "!\n\n"
        },
        "metadata": {
          "finishReason": null,
          "contentFilters": [],
          "empty": true
        }
      }
    ],
    "metadata": {
      "id": "",
      "model": "deepseek-r1:1.5b",
      "rateLimit": {
        "requestsLimit": 0,
        "requestsRemaining": 0,
        "requestsReset": "PT0S",
        "tokensRemaining": 0,
        "tokensLimit": 0,
        "tokensReset": "PT0S"
      },
      "usage": {
        "promptTokens": 0,
        "completionTokens": 0,
        "totalTokens": 0
      },
      "promptMetadata": [],
      "empty": false
    }
  },
  {
    "result": {
      "output": {
        "messageType": "ASSISTANT",
        "metadata": {
          "messageType": "ASSISTANT"
        },
        "toolCalls": [],
        "media": [],
        "text": "😄"
      },
      "metadata": {
        "finishReason": null,
        "contentFilters": [],
        "empty": true
      }
    },
    "results": [
      {
        "output": {
          "messageType": "ASSISTANT",
          "metadata": {
            "messageType": "ASSISTANT"
          },
          "toolCalls": [],
          "media": [],
          "text": "😄"
        },
        "metadata": {
          "finishReason": null,
          "contentFilters": [],
          "empty": true
        }
      }
    ],
    "metadata": {
      "id": "",
      "model": "deepseek-r1:1.5b",
      "rateLimit": {
        "requestsLimit": 0,
        "requestsRemaining": 0,
        "requestsReset": "PT0S",
        "tokensRemaining": 0,
        "tokensLimit": 0,
        "tokensReset": "PT0S"
      },
      "usage": {
        "promptTokens": 0,
        "completionTokens": 0,
        "totalTokens": 0
      },
      "promptMetadata": [],
      "empty": false
    }
  },
  {
    "result": {
      "output": {
        "messageType": "ASSISTANT",
        "metadata": {
          "messageType": "ASSISTANT"
        },
        "toolCalls": [],
        "media": [],
        "text": ""
      },
      "metadata": {
        "finishReason": "stop",
        "contentFilters": [],
        "empty": true
      }
    },
    "results": [
      {
        "output": {
          "messageType": "ASSISTANT",
          "metadata": {
            "messageType": "ASSISTANT"
          },
          "toolCalls": [],
          "media": [],
          "text": ""
        },
        "metadata": {
          "finishReason": "stop",
          "contentFilters": [],
          "empty": true
        }
      }
    ],
    "metadata": {
      "id": "",
      "model": "deepseek-r1:1.5b",
      "rateLimit": {
        "requestsLimit": 0,
        "requestsRemaining": 0,
        "requestsReset": "PT0S",
        "tokensRemaining": 0,
        "tokensLimit": 0,
        "tokensReset": "PT0S"
      },
      "usage": {
        "promptTokens": 6,
        "completionTokens": 37,
        "totalTokens": 43
      },
      "promptMetadata": [],
      "empty": false
    }
  }
] 
````