import inspect


class Debugger(object):
    attribute_accesses = []
    method_calls = []


class Meta(type):
    # print type(type)
    # your solution
    def __new__(meta, name,
                bases, dct):
        return super(Meta, meta).__new__(meta, name, bases, dct)

    def __call__(cls, *args, **kwargs):
        Debugger.method_calls.append({
            'class': cls,
            'method': vars(cls).items()[0][1],
            'args': args,
            'kwargs': kwargs
        })
        return type.__call__(cls, *args, **kwargs)

