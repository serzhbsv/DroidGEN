#include "types.h"
#include "config.h"
#include "m68k/m68k.h"
#include "membnk.h"

/* Определения глобальных переменных */
t_config config;
_m68k_memory_map m68k_memory_map[256];
struct _zbank_memory_map zbank_memory_map[256];